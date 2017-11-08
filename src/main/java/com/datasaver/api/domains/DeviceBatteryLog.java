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
public class DeviceBatteryLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;
	
	@Column(name = "chargeType")
	private ChargeType chargeType;
	
	@Column(name = "percent")
	private float percent;
	
	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;
	
	@ManyToOne
	@JoinColumn(name = "didx")
	private Device device;

	public enum ChargeType {
		NO(0), USB(1), AC(2), WIRELESS(3);

		private int code;

		private ChargeType(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
	}

	public DeviceBatteryLog() {
	}

	public DeviceBatteryLog(long idx, ChargeType chargeType, float percent, Timestamp ts, Device device) {
		this.idx = idx;
		this.chargeType = chargeType;
		this.percent = percent;
		this.ts = ts;
		this.device = device;
	}
	
	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	public ChargeType getChargeType() {
		return chargeType;
	}

	public void setChargeType(ChargeType chargeType) {
		this.chargeType = chargeType;
	}

	public float getPercent() {
		return percent;
	}

	public void setPercent(float percent) {
		this.percent = percent;
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