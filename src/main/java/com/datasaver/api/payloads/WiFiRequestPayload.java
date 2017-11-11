package com.datasaver.api.payloads;

public class WiFiRequestPayload {
	private long requesterUidx;
	private long requesWidx;

	public WiFiRequestPayload() {
	}

	public WiFiRequestPayload(long requesterUidx, long requesWidx) {
		this.requesterUidx = requesterUidx;
		this.requesWidx = requesWidx;
	}

	public long getRequesterUidx() {
		return requesterUidx;
	}

	public void setRequesterUidx(long requesterUidx) {
		this.requesterUidx = requesterUidx;
	}

	public long getRequesWidx() {
		return requesWidx;
	}

	public void setRequesWidx(long requesWidx) {
		this.requesWidx = requesWidx;
	}
}