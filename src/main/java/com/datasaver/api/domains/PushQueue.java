package com.datasaver.api.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PushQueue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;

	@Column(name = "type")
	private Type type;

	@Column(name = "title")
	private String title;

	@Column(name = "contents")
	private String contents;

	@Column(name = "log")
	private String log;

	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;

	@ManyToOne
	@JoinColumn(name = "didx")
	private Device device;

	public enum Type {
		FAIL(-1), SUCCESS(1), WAIT(0);

		private int code;

		private Type(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
	}

	public PushQueue() {
	}

	public PushQueue(long idx, Type type, String title, String contents, String log, Timestamp ts, Device device) {
		this.idx = idx;
		this.type = type;
		this.title = title;
		this.contents = contents;
		this.log = log;
		this.ts = ts;
		this.device = device;
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
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

	public Device getDevice() {
		return device;
	}

	public void setDevices(Device device) {
		this.device = device;
	}
}
