package com.datasaver.api.controllers.forms;

import com.datasaver.api.domains.DeviceRingerLog;
import com.datasaver.api.domains.DeviceRingerLog.Type;

public class AddRingerLogForm {
	private DeviceRingerLog.Type type;
	private int volume;
	
	public AddRingerLogForm() {
	}
	
	public AddRingerLogForm(Type type, int volume) {
		this.type = type;
		this.volume = volume;
	}

	public DeviceRingerLog.Type getType() {
		return type;
	}

	public void setType(DeviceRingerLog.Type type) {
		this.type = type;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
}
