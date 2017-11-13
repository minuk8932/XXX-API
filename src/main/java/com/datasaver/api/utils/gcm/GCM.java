package com.datasaver.api.utils.gcm;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import com.datasaver.api.utils.res.Strings;
import com.google.gson.Gson;

public class GCM {
	private static final String SERVER_URL = "https://gcm-http.googleapis.com/gcm/send";

	private HttpURLConnection huc;

	public GCM(String apiKey) {
		try {
			huc = (HttpURLConnection) new URL(SERVER_URL).openConnection();
			huc.setRequestProperty("Authorization", "key=" + apiKey);
			huc.setRequestProperty("Content-Type", "application/json");
			huc.setRequestMethod("POST");
			huc.setDoOutput(true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public JSONObject send(String title, String contents, Object payload, String token) {
		if (huc == null) {
			System.out.println(Strings.CAN_NOT_CREATE_HTTP_URL_CONNECTION);

			return null;
		}

		try {
			requestToServer(createMsg(title, contents, payload, token));

			return responseFromServer();
		} catch (Exception e) {
			System.out.println(e.getMessage());

			return null;
		} finally {
			huc.disconnect();
		}
	}

	private void requestToServer(JSONObject msgJO) throws Exception {
		OutputStream os = null;

		try {
			os = huc.getOutputStream();
			os.write(msgJO.toString().getBytes());
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}

	private JSONObject responseFromServer() throws Exception {
		InputStream is = null;

		try {
			is = huc.getInputStream();

			return new JSONObject(IOUtils.toString(is));
		} finally {
			if (is != null) {
				is.close();
			}
		}
	}

	private JSONObject createDataJO(String title, String contents, Object payload) {
		try {
			JSONObject dataJO = new JSONObject(new Gson().toJson(payload));
			dataJO.put("title", title);
			dataJO.put("contents", contents);

			return dataJO;
		} catch (Exception e) {
			System.out.println("에러 에바야3..." + e.getMessage());

			return null;
		}
	}

	private JSONObject createMsg(String title, String contents, Object payload, String token) {
		try {
			JSONObject msgJO = new JSONObject();
			msgJO.put("data", createDataJO(title, contents, payload));
			msgJO.put("to", token);

			return msgJO;
		} catch (Exception e) {
			System.out.println("에러 에바야4..." + e.getMessage());

			return null;
		}
	}
}