package com.datasaver.api.controllers.responses.data;

public class GetProfileResponseData {
	private long idx;
	private String name;
	private String phoneNumber;
	private String profileImg;
	private MostRecentlyUsedWiFi mostRecentlyUsedWiFi;

	public GetProfileResponseData() {
	}

	public GetProfileResponseData(long idx, String name, String phoneNumber, String profileImg,
			MostRecentlyUsedWiFi mostRecentlyUsedWiFi) {
		this.idx = idx;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.profileImg = profileImg;
		this.mostRecentlyUsedWiFi = mostRecentlyUsedWiFi;
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public MostRecentlyUsedWiFi getMostRecentlyUsedWiFi() {
		return mostRecentlyUsedWiFi;
	}

	public void setMostRecentlyUsedWiFi(MostRecentlyUsedWiFi mostRecentlyUsedWiFi) {
		this.mostRecentlyUsedWiFi = mostRecentlyUsedWiFi;
	}

	public static class MostRecentlyUsedWiFi {
		private String ssid;
		private double latitude;
		private double longitude;

		public MostRecentlyUsedWiFi() {
		}

		public MostRecentlyUsedWiFi(String ssid, double latitude, double longitude) {
			this.ssid = ssid;
			this.latitude = latitude;
			this.longitude = longitude;
		}

		public String getSsid() {
			return ssid;
		}

		public void setSsid(String ssid) {
			this.ssid = ssid;
		}

		public double getLatitude() {
			return latitude;
		}

		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}

		public double getLongitude() {
			return longitude;
		}

		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}
	}
}