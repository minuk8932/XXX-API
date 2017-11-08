package com.datasaver.api.controllers.responses.data;

public class CheckEmailResponseData {
	private boolean exist;

	public CheckEmailResponseData(boolean exist) {
		this.exist = exist;
	}
	
	public boolean getExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}
}