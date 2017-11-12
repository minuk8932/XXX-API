package com.datasaver.api.services;

import java.util.Collection;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.datasaver.api.domains.Device;
import com.datasaver.api.domains.PushMessage;
import com.datasaver.api.domains.PushMessage.Status;
import com.datasaver.api.domains.PushMessage.Type;
import com.datasaver.api.domains.User;
import com.datasaver.api.domains.WiFi;
import com.datasaver.api.payloads.AddNoticePayload;
import com.datasaver.api.payloads.UpdateNoticePayload;
import com.datasaver.api.payloads.WiFiRequestPayload;
import com.datasaver.api.payloads.WiFiRequestResultPayload;
import com.datasaver.api.repositories.PushMessageRepository;
import com.datasaver.api.services.interfaces.PushMessageServiceInterface;
import com.datasaver.api.utils.fcm.FCM;
import com.datasaver.api.utils.fcm.FCMConfig;
import com.google.gson.Gson;

@Service("PushMessageService")
public class PushMessageService implements PushMessageServiceInterface {
	private static final int PAGE_SIZE = 20;

	@Autowired
	private PushMessageRepository pmr;

	@Autowired
	private UserService us;

	@Autowired
	private FCMConfig fc;

	@Autowired
	private DeviceService ds;

	@Override
	public void sendAddNoticeMsg(AddNoticePayload addNoticePayload) {
		for (User u : us.findAll()) {
			PushMessage pm = new PushMessage();
			pm.setType(Type.ADD_NOTICE);
			pm.setPayload(new Gson().toJson(addNoticePayload));
			pm.setUser(u);
			pm.setIsRead(false);

			FCM fcm = new FCM(fc.getApiKey());
			Device d = ds.findByUser(u);

			if (d == null) {
				pm.setStatus(Status.FAIL);
			}

			else {
				JSONObject resJO = fcm.send("[DataSaver] 새로운 공지사항이 있어요.", addNoticePayload.getTitle(), addNoticePayload,
						d.getToken());

				if (resJO != null) {
					pm.setLog(resJO.toString());
				}

				pm.setStatus(Status.SUCCESS);
			}

			pmr.save(pm);
		}
	}

	@Override
	public void sendUpdateNoticeMsg(UpdateNoticePayload updateNoticePayload) {
		for (User u : us.findAll()) {
			PushMessage pm = new PushMessage();
			pm.setType(Type.UPDATE_NOTICE);
			pm.setPayload(new Gson().toJson(updateNoticePayload));
			pm.setUser(u);
			pm.setIsRead(false);

			FCM fcm = new FCM(fc.getApiKey());
			String token = ds.findByUser(u).getToken();
			pm.setLog(fcm.send("[DataSaver] 공지사항이 변경되었어요.", updateNoticePayload.getTitle(), updateNoticePayload, token)
					.toString());

			pm.setStatus(Status.SUCCESS);

			pmr.save(pm);
		}
	}

	@Override
	public boolean sendWiFiRequestMsg(User owner, User requester, WiFi wifi, WiFiRequestPayload wifiRequestPayload) {
		PushMessage pm = new PushMessage();
		pm.setType(Type.WIFI_REQUEST);
		pm.setPayload(new Gson().toJson(wifiRequestPayload));
		pm.setUser(owner);
		pm.setIsRead(false);

		FCM fcm = new FCM(fc.getApiKey());
		String token = ds.findByUser(owner).getToken();
		pm.setLog(fcm
				.send("[DataSaver] WiFi 정보 공유 요청이 있어요.",
						requester.getName() + "님이 " + wifi.getSsid() + " 정보 공유를 요청했어요.", wifiRequestPayload, token)
				.toString());

		pm.setStatus(Status.SUCCESS);

		pmr.save(pm);

		return true;
	}

	@Override
	public boolean sendWiFiRequestResultMsg(User requester, WiFi wifi,
			WiFiRequestResultPayload wifiRequestResultPayload) {
		PushMessage pm = new PushMessage();
		pm.setType(Type.WIFI_REQUEST_RESULT);
		pm.setPayload(new Gson().toJson(wifiRequestResultPayload));
		pm.setUser(requester);
		pm.setIsRead(false);

		FCM fcm = new FCM(fc.getApiKey());
		String token = ds.findByUser(requester).getToken();

		if (wifiRequestResultPayload.getStatus()) {
			pm.setLog(fcm.send("[DataSaver] WiFi 정보 공유를 허락 받았어요.", wifi.getSsid() + " 정보를 추가했어요.",
					wifiRequestResultPayload, token).toString());
		}

		else {
			pm.setLog(fcm.send("[DataSaver] WiFi 정보 공유를 거절당했어요.", wifi.getSsid() + " 정보 공유를 거절당했어요.",
					wifiRequestResultPayload, token).toString());
		}

		pm.setStatus(Status.SUCCESS);

		pmr.save(pm);

		return true;
	}

	@Override
	public void save(PushMessage pushMessage) {
		pmr.save(pushMessage);
	}

	@Override
	public PushMessage findByIdx(long idx) {
		return pmr.findOne(idx);
	}

	@Override
	public Collection<PushMessage> findListByUser(User user, int page) {
		return pmr.findListByUser(user, new PageRequest(page, PAGE_SIZE)).getContent();
	}
}