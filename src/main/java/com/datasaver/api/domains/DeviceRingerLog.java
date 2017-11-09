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
public class DeviceRingerLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;

	@Column(name = "type")
	private Type type;

	@Column(name = "volume")
	private int volume;

	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;

	@ManyToOne
	@JoinColumn(name = "didx")
	private Device device;

	public enum Type {
		NORMAL(0), SILENT(1), VIBRATE(2);

		private int code;

		private Type(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
	}

	public DeviceRingerLog() {
	}

	public DeviceRingerLog(long idx, Type type, int volume, Timestamp ts) {
		this.idx = idx;
		this.type = type;
		this.volume = volume;
		this.ts = ts;
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

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
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

	public void setDevice(Device device) {
		this.device = device;
	}
}
