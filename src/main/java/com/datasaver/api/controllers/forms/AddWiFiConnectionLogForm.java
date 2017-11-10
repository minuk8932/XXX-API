package com.datasaver.api.controllers.forms;

import com.datasaver.api.domains.WiFiConnectionLog;
import com.datasaver.api.domains.WiFiConnectionLog.Type;

public class AddWiFiConnectionLogForm {
	public WiFiConnectionLog.Type type;

	public AddWiFiConnectionLogForm() {
	}
	
	public AddWiFiConnectionLogForm(Type type) {
		this.type = type;
	}

	public WiFiConnectionLog.Type getType() {
		return type;
	}

	public void setType(WiFiConnectionLog.Type type) {
		this.type = type;
	}
}
