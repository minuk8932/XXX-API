package com.datasaver.api.payloads;

public class WiFiResponsePayload {
	private long requesterUidx;
	private long requesWidx;
	private boolean status;

	public WiFiResponsePayload() {
	}

	public WiFiResponsePayload(long requesterUidx, long requesWidx, boolean status) {
		this.requesterUidx = requesterUidx;
		this.requesWidx = requesWidx;
		this.status = status;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}