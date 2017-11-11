package com.datasaver.api.payloads;

public class AddNoticePayload {
	private long idx;
	private String title;

	public AddNoticePayload() {
	}

	public AddNoticePayload(long idx, String title) {
		this.idx = idx;
		this.title = title;
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}