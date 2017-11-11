package com.datasaver.api.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
	private static final int PAGE_SIZE = 20;

	@Autowired
	private PushMessageRepository pmr;

	@Autowired
	private UserService us;

	@Override
	public void sendAddNoticeMsg(AddNoticePayload addNoticePayload) {
		for (User u : us.findAll()) {
			PushMessage pm = new PushMessage();
			pm.setType(Type.ADD_NOTICE);
			pm.setPayload(new Gson().toJson(addNoticePayload));
			pm.setUser(u);
			pm.setIsRead(false);

			// TODO : Send push message.
			pm.setLog("");

			pm.setStatus(Status.SUCCESS);
			pm.setStatus(Status.FAIL);

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

			// TODO : Send push message.
			pm.setLog("");

			pm.setStatus(Status.SUCCESS);
			pm.setStatus(Status.FAIL);

			pmr.save(pm);
		}
	}

	@Override
	public boolean sendWiFiRequestMsg(User user, WiFiRequestPayload wifiRequestPayload) {
		PushMessage pm = new PushMessage();
		pm.setType(Type.WIFI_REQUEST);
		pm.setPayload(new Gson().toJson(wifiRequestPayload));
		pm.setUser(user);
		pm.setIsRead(false);

		// TODO : Send push message.
		pm.setLog("");

		pm.setStatus(Status.FAIL);

		pmr.save(pm);

		return true;
	}

	@Override
	public boolean sendWiFiRequestResultMsg(User user, WiFiRequestResultPayload wifiRequestResultPayload) {
		PushMessage pm = new PushMessage();
		pm.setType(Type.WIFI_REQUEST_RESULT);
		pm.setPayload(new Gson().toJson(wifiRequestResultPayload));
		pm.setUser(user);
		pm.setIsRead(false);

		// TODO : Send push message.
		pm.setLog("");

		pm.setStatus(Status.FAIL);

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