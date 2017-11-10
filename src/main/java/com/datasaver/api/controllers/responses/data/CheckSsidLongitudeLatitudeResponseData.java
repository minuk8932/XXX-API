package com.datasaver.api.controllers.responses.data;

public class CheckSsidLongitudeLatitudeResponseData {
	private boolean exist;

	public CheckSsidLongitudeLatitudeResponseData(boolean exist) {
		this.exist = exist;
	}

	public boolean isExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}
}
