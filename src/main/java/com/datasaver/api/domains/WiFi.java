package com.datasaver.api.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WiFi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;

	@Column(name = "ssid")
	private String ssid;

	@Column(name = "password")
	private String password;

	@Column(name = "authType")
	private AuthType authType;

	@Column(name = "channel")
	private String channel;

	@Column(name = "longitude")
	private double longitude;

	@Column(name = "latitude")
	private double latitude;

	@Column(name = "ts")
	private Timestamp ts;

	public enum AuthType {
		NO(0), WEP64(1), WEP128(2), TKIP(3), AES(4), TKIP_AES(5), WPA2PSK_AES(6);

		private int code;

		private AuthType(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
	}

	public WiFi() {
	}

	public WiFi(long idx, String ssid, String password, AuthType authType, String channel, double longitude,
			double latitude, Timestamp ts) {
		this.idx = idx;
		this.ssid = ssid;
		this.password = password;
		this.authType = authType;
		this.channel = channel;
		this.longitude = longitude;
		this.latitude = latitude;
		this.ts = ts;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AuthType getAuthType() {
		return authType;
	}

	public void setAuthType(AuthType authType) {
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

	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
}