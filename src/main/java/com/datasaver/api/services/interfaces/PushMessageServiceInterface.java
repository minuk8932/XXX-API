package com.datasaver.api.services.interfaces;

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
}