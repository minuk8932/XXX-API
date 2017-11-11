package com.datasaver.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasaver.api.domains.PushMessage;
import com.datasaver.api.domains.PushMessage.Status;
import com.datasaver.api.domains.PushMessage.Type;
import com.datasaver.api.domains.User;
import com.datasaver.api.payloads.AddNoticePayload;
import com.datasaver.api.payloads.UpdateNoticePayload;
import com.datasaver.api.payloads.WiFiRequestPayload;
import com.datasaver.api.payloads.WiFiRequestResultPayload;
import com.datasaver.api.repositories.PushMessageRepository;
import com.datasaver.api.services.interfaces.PushMessageServiceInterface;
import com.google.gson.Gson;

@Service("PushMessageService")
public class PushMessageService implements PushMessageServiceInterface {
	@Autowired
	private PushMessageRepository pr;

	@Autowired
	private UserService us;

	@Override
	public void sendAddNoticeMsg(AddNoticePayload addNoticePayload) {
		for (User u : us.findAll()) {
			PushMessage pm = new PushMessage();
			pm.setType(Type.ADD_NOTICE);
			pm.setPayload(new Gson().toJson(addNoticePayload));
			pm.setUser(u);

			// TODO : Send push message.
			pm.setLog("");

			pm.setStatus(Status.SUCCESS);
			pm.setStatus(Status.FAIL);

			pr.save(pm);
		}
	}

	@Override
	public void sendUpdateNoticeMsg(UpdateNoticePayload updateNoticePayload) {
		for (User u : us.findAll()) {
			PushMessage pm = new PushMessage();
			pm.setType(Type.UPDATE_NOTICE);
			pm.setPayload(new Gson().toJson(updateNoticePayload));
			pm.setUser(u);

			// TODO : Send push message.
			pm.setLog("");

			pm.setStatus(Status.SUCCESS);
			pm.setStatus(Status.FAIL);

			pr.save(pm);
		}
	}

	@Override
	public boolean sendWiFiRequestMsg(User user, WiFiRequestPayload wifiRequestPayload) {
		PushMessage pm = new PushMessage();
		pm.setType(Type.WIFI_REQUEST);
		pm.setPayload(new Gson().toJson(wifiRequestPayload));
		pm.setUser(user);

		// TODO : Send push message.
		pm.setLog("");

		pm.setStatus(Status.FAIL);

		pr.save(pm);

		return true;
	}

	@Override
	public boolean sendWiFiRequestResultMsg(User user, WiFiRequestResultPayload wifiRequestResultPayload) {
		PushMessage pm = new PushMessage();
		pm.setType(Type.WIFI_REQUEST_RESULT);
		pm.setPayload(new Gson().toJson(wifiRequestResultPayload));
		pm.setUser(user);

		// TODO : Send push message.
		pm.setLog("");

		pm.setStatus(Status.FAIL);

		pr.save(pm);

		return true;
	}
}