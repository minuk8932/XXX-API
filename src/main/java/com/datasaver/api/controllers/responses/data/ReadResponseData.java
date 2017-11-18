package com.datasaver.api.controllers.responses.data;

public class ReadResponseData {
	private int unreadCounts;

	public ReadResponseData() {
	}

	public ReadResponseData(int unreadCounts) {
		this.unreadCounts = unreadCounts;
	}

	public int getUnreadCounts() {
		return unreadCounts;
	}

	public void setUnreadCounts(int unreadCounts) {
		this.unreadCounts = unreadCounts;
	}
}