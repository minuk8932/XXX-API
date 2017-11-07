package com.datasaver.api.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PushQueue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;

	@Column(name = "type")
	private type type;

	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

	@Column(name = "log")
	private String log;

	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;

	public enum type {
		FAILED(-1), SUCCESS(1), WAIT(0);

		private int code;

		private type(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
	}

	public PushQueue() {
	}

	public PushQueue(long idx, type type, String title, String content, String log, Timestamp ts) {
		this.idx = idx;
		this.type = type;
		this.title = title;
		this.content = content;
		this.log = log;
		this.ts = ts;
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	public type getType() {
		return type;
	}

	public void setType(type type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
}
