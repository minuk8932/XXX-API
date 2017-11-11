package com.datasaver.api.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DeviceLocationLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;

	@Column(name = "sensorType")
	private SensorType sensorType;

	@Column(name = "longitude")
	private double longitude;

	@Column(name = "latitude")
	private double latitude;

	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;

	@ManyToOne
	@JoinColumn(name = "didx")
	@JsonIgnore
	private Device device;

	public enum SensorType {
		GPS(0), NETWORK(1);

		private int code;

		private SensorType(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
	}

	public DeviceLocationLog() {
	}

	public DeviceLocationLog(long idx, SensorType sensorType, double longitude, double latitude, Timestamp ts,
			Device device) {
		this.idx = idx;
		this.sensorType = sensorType;
		this.longitude = longitude;
		this.latitude = latitude;
		this.ts = ts;
		this.device = device;
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	public SensorType getSensorType() {
		return sensorType;
	}

	public void setSensorType(SensorType sensorType) {
		this.sensorType = sensorType;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
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
