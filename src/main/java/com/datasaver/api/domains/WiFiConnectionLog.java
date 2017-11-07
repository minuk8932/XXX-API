package com.datasaver.api.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class WiFiConnectionLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;
	
	@Column(name = "type")
	private type type;
	
	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;
	
	@OneToOne
	@JoinColumn(name = "widx")
	private WiFi wifi;
	
	public enum type{
		DISCONNECTION(0), CONNECTION(1);
		
		private int code;
		
		private type(int code) {
			this.code = code;
		}
		
		public int getCode() {
			return code;
		}
	}
	
	public WiFiConnectionLog() {
	}

	public WiFiConnectionLog(long idx, type type, Timestamp ts, WiFi wifi) {
		super();
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

	public type getType() {
		return type;
	}

	public void setType(type type) {
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
