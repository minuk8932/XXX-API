package com.datasaver.api.controllers.forms;

import com.datasaver.api.domains.Device;
import com.datasaver.api.domains.Device.Type;

public class AddDeviceForm {
	private String token;
	private Device.Type type;
	private String uuid;

	public AddDeviceForm() {
	}

	public AddDeviceForm(String token, Type type, String uuid) {
		this.token = token;
		this.type = type;
		this.uuid = uuid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Device.Type getType() {
		return type;
	}

	public void setType(Device.Type type) {
		this.type = type;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}