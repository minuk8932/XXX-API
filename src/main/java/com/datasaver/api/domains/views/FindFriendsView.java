package com.datasaver.api.domains.views;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FindFriendsView {
	@Id
	private long idx;
	private String name;
	private String profileImg;

	public FindFriendsView() {
	}

	public FindFriendsView(long idx, String name, String profileImg) {
		this.idx = idx;
		this.name = name;
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

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
}