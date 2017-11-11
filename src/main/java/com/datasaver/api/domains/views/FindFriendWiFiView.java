package com.datasaver.api.domains.views;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FindFriendWiFiView {
	@Id
	private long idx;
	private String ssid;
	private double longitude;
	private double latitude;

	public FindFriendWiFiView() {
	}

	public FindFriendWiFiView(long idx, String ssid, double longitude, double latitude) {
		this.idx = idx;
		this.ssid = ssid;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
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
}