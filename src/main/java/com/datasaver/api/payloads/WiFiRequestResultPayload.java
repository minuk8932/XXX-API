package com.datasaver.api.payloads;

import com.datasaver.api.domains.WiFi;

public class WiFiRequestResultPayload {
	private boolean status;
	private WiFi wifi;

	public WiFiRequestResultPayload() {
	}

	public WiFiRequestResultPayload(boolean status, WiFi wifi) {
		this.status = status;
		this.wifi = wifi;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public WiFi getWifi() {
		return wifi;
	}

	public void setWifi(WiFi wifi) {
		this.wifi = wifi;
	}
}