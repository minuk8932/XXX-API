package com.datasaver.api.controllers.responses.data;

import java.sql.Timestamp;

import com.datasaver.api.domains.PushMessage;
import com.datasaver.api.domains.PushMessage.Type;

public class GetPushMessageResponseData {
	private long idx;
	private PushMessage.Type type;
	private Object payload;
	private boolean isRead;
	private Timestamp ts;

	public GetPushMessageResponseData() {
	}

	public GetPushMessageResponseData(long idx, Type type, Object payload, boolean isRead, Timestamp ts) {
		this.idx = idx;
		this.type = type;
		this.payload = payload;
		this.isRead = isRead;
		this.ts = ts;
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	public PushMessage.Type getType() {
		return type;
	}

	public void setType(PushMessage.Type type) {
		this.type = type;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	public boolean getIsRead() {
		return isRead;
	}

	public void setIsRead(boolean isRead) {
		this.isRead = isRead;
	}

	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
}