package com.datasaver.api.controllers.forms;

import com.datasaver.api.domains.WiFi;
import com.datasaver.api.domains.WiFi.AuthType;
import com.datasaver.api.domains.WiFiConnectionLog;

public class AddWiFiConnectionLogForm {
	private String ssid;

	private String mac;

	private String password;

	private WiFi.AuthType authType;

	private String channel;

	private double longitude;

	private double latitude;

	private WiFiConnectionLog.Type type;

	public AddWiFiConnectionLogForm() {
	}

	public AddWiFiConnectionLogForm(String ssid, String mac, String password, AuthType authType, String channel,
			double longitude, double latitude, WiFiConnectionLog.Type type) {
		this.ssid = ssid;
		this.mac = mac;
		this.password = password;
		this.authType = authType;
		this.channel = channel;
		this.longitude = longitude;
		this.latitude = latitude;
		this.type = type;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public WiFi.AuthType getAuthType() {
		return authType;
	}

	public void setAuthType(WiFi.AuthType authType) {
		this.authType = authType;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public WiFiConnectionLog.Type getType() {
		return type;
	}

	public void setType(WiFiConnectionLog.Type type) {
		this.type = type;
	}
}
