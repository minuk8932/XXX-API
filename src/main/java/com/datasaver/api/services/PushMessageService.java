package com.datasaver.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasaver.api.domains.PushMessage;
import com.datasaver.api.domains.PushMessage.Status;
import com.datasaver.api.domains.PushMessage.Type;
import com.datasaver.api.payloads.AddNoticePayload;
import com.datasaver.api.payloads.UpdateNoticePayload;
import com.datasaver.api.payloads.WiFiRequestPayload;
import com.datasaver.api.payloads.WiFiResponsePayload;
import com.datasaver.api.repositories.PushMessageRepository;
import com.datasaver.api.services.interfaces.PushMessageServiceInterface;
import com.google.gson.Gson;

@Service("PushMessageService")
public class PushMessageService implements PushMessageServiceInterface {
	@Autowired
	PushMessageRepository pr;

	@Override
	public boolean sendAddNoticeMsg(AddNoticePayload addNoticePayload) {
		return true;
	}

	@Override
	public boolean sendUpdateNoticeMsg(UpdateNoticePayload updateNoticePayload) {
		return true;
	}

	@Override
	public boolean sendWiFiRequestMsg(WiFiRequestPayload wifiRequestPayload) {
		// TODO : Send push message.

		boolean res = true;

		PushMessage pm = new PushMessage();
		pm.setType(Type.WIFI_REQUEST);
		pm.setPayload(new Gson().toJson(wifiRequestPayload));
		pm.setLog("");

		if (res)
			pm.setStatus(Status.SUCCESS);
		else
			pm.setStatus(Status.FAIL);

		pr.save(pm);

		return true;
	}

	@Override
	public boolean sendWiFiResponseMsg(WiFiResponsePayload wifiResponsePayload) {
		return false;
	}
}