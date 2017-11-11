package com.datasaver.api.controllers.forms;

public class RequestForm {
	private long requestWidx;

	public RequestForm() {
	}

	public RequestForm(long requestWidx) {
		this.requestWidx = requestWidx;
	}

	public long getRequestWidx() {
		return requestWidx;
	}

	public void setRequestWidx(long requestWidx) {
		this.requestWidx = requestWidx;
	}
}