package com.datasaver.api.payloads;

public class UpdateNoticePayload {
	private long idx;
	private long title;

	public UpdateNoticePayload() {
	}

	public UpdateNoticePayload(long idx, long title) {
		this.idx = idx;
		this.title = title;
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	public long getTitle() {
		return title;
	}

	public void setTitle(long title) {
		this.title = title;
	}
}