package com.datasaver.api.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class WiFiConnectionLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;

	@Column(name = "type")
	private Type type;

	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;

	@OneToOne
	@JoinColumn(name = "widx")
	@JsonIgnore
	private WiFi wifi;

	public enum Type {
		DISCONNECT(0), CONNECT(1);

		private int code;

		private Type(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
	}

	public WiFiConnectionLog() {
	}

	public WiFiConnectionLog(long idx, Type type, Timestamp ts, WiFi wifi) {
		this.idx = idx;
		this.type = type;
		this.ts = ts;
		this.wifi = wifi;
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

	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

	public WiFi getWifi() {
		return wifi;
	}

	public void setWifi(WiFi wifi) {
		this.wifi = wifi;
	}
}
