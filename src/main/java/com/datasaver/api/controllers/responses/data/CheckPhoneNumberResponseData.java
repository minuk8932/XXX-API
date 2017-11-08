package com.datasaver.api.controllers.responses.data;

public class CheckPhoneNumberResponseData {
	private boolean exist;

	public CheckPhoneNumberResponseData(boolean exist) {
		this.exist = exist;
	}

	public boolean getExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}
}