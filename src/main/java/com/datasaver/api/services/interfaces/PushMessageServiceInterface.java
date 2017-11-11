package com.datasaver.api.services.interfaces;

import com.datasaver.api.payloads.AddNoticePayload;
import com.datasaver.api.payloads.UpdateNoticePayload;
import com.datasaver.api.payloads.WiFiRequestPayload;
import com.datasaver.api.payloads.WiFiResponsePayload;

public interface PushMessageServiceInterface {
	public boolean sendAddNoticeMsg(AddNoticePayload addNoticePayload);

	public boolean sendUpdateNoticeMsg(UpdateNoticePayload updateNoticePayload);

	public boolean sendWiFiRequestMsg(WiFiRequestPayload wifiRequestPayload);

	public boolean sendWiFiResponseMsg(WiFiResponsePayload wifiResponsePayload);
}