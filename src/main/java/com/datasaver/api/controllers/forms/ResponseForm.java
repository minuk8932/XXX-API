package com.datasaver.api.controllers.forms;

public class ResponseForm {
	private long requesterUidx;
	private long requestWidx;
	private boolean status;

	public ResponseForm() {
	}

	public ResponseForm(long requesterUidx, long requestWidx, boolean status) {
		this.requesterUidx = requesterUidx;
		this.requestWidx = requestWidx;
		this.status = status;
	}

	public long getRequesterUidx() {
		return requesterUidx;
	}

	public void setRequesterUidx(long requesterUidx) {
		this.requesterUidx = requesterUidx;
	}

	public long getRequestWidx() {
		return requestWidx;
	}

	public void setRequestWidx(long requestWidx) {
		this.requestWidx = requestWidx;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}