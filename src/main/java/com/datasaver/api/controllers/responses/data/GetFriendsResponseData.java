package com.datasaver.api.controllers.responses.data;

public class GetFriendsResponseData {
	private MyProfile myProfile;
	private Friend[] friends;

	public GetFriendsResponseData() {
	}

	public GetFriendsResponseData(MyProfile myProfile, Friend[] friends) {
		this.myProfile = myProfile;
		this.friends = friends;
	}

	public MyProfile getMyProfile() {
		return myProfile;
	}

	public void setMyProfile(MyProfile myProfile) {
		this.myProfile = myProfile;
	}

	public Friend[] getFriends() {
		return friends;
	}

	public void setFriends(Friend[] friends) {
		this.friends = friends;
	}

	public static class MyProfile {
		private long idx;
		private String name;
		private String profileImgUrl;

		public MyProfile() {
		}

		public MyProfile(long idx, String name, String profileImgUrl) {
			this.idx = idx;
			this.name = name;
			this.profileImgUrl = profileImgUrl;
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

		public String getProfileImgUrl() {
			return profileImgUrl;
		}

		public void setProfileImgUrl(String profileImgUrl) {
			this.profileImgUrl = profileImgUrl;
		}
	}

	public static class Friend {
		private long idx;
		private String name;
		private String profileImgUrl;
		private MostRecentlyUsedWiFi mostRecentlyUsedWiFi;

		public Friend() {
		}

		public Friend(long idx, String name, String profileImgUrl, MostRecentlyUsedWiFi mostRecentlyUsedWiFi) {
			this.idx = idx;
			this.name = name;
			this.profileImgUrl = profileImgUrl;
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

		public String getProfileImgUrl() {
			return profileImgUrl;
		}

		public void setProfileImgUrl(String profileImgUrl) {
			this.profileImgUrl = profileImgUrl;
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
}