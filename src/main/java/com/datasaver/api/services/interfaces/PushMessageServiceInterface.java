package com.datasaver.api.services.interfaces;

import java.util.Collection;

import com.datasaver.api.domains.PushMessage;
import com.datasaver.api.domains.User;
import com.datasaver.api.payloads.AddNoticePayload;
import com.datasaver.api.payloads.UpdateNoticePayload;
import com.datasaver.api.payloads.WiFiRequestPayload;
import com.datasaver.api.payloads.WiFiRequestResultPayload;

public interface PushMessageServiceInterface {
	public void sendAddNoticeMsg(AddNoticePayload addNoticePayload);

	public void sendUpdateNoticeMsg(UpdateNoticePayload updateNoticePayload);

	public boolean sendWiFiRequestMsg(User user, WiFiRequestPayload wifiRequestPayload);

	public boolean sendWiFiRequestResultMsg(User user, WiFiRequestResultPayload wifiRequestResultPayload);

	public void save(PushMessage pushMessage);

	public PushMessage findByIdx(long idx);

	public Collection<PushMessage> findListByUser(User user, int page);
}