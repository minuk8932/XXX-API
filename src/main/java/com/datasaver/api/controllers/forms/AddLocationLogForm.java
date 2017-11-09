package com.datasaver.api.controllers.forms;

import com.datasaver.api.domains.DeviceLocationLog;
import com.datasaver.api.domains.DeviceLocationLog.SensorType;

public class AddLocationLogForm {
	private DeviceLocationLog.SensorType sensorType;
	private double longitude;
	private double latitude;
	
	public AddLocationLogForm() {
	}

	public AddLocationLogForm(SensorType sensorType, double longitude, double latitude) {
		this.sensorType = sensorType;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public DeviceLocationLog.SensorType getSensorType() {
		return sensorType;
	}

	public void setSensorType(DeviceLocationLog.SensorType sensorType) {
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
}
