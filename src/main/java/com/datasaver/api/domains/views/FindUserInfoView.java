package com.datasaver.api.domains.views;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FindUserInfoView {
	@Id
	private long idx;
	private String name;
	private String phoneNumber;
	private String profileImg;

	public FindUserInfoView() {
	}

	public FindUserInfoView(long idx, String name, String phoneNumber, String profileImg) {
		this.idx = idx;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.profileImg = profileImg;
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
}