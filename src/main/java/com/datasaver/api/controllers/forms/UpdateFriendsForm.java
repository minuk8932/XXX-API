package com.datasaver.api.controllers.forms;

public class UpdateFriendsForm {
	private long[] fuidxs;

	public UpdateFriendsForm() {
	}

	public UpdateFriendsForm(long[] fuidxs) {
		this.fuidxs = fuidxs;
	}

	public long[] getFuidxs() {
		return fuidxs;
	}

	public void setFuidxs(long[] fuidxs) {
		this.fuidxs = fuidxs;
	}
}