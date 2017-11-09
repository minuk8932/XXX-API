package com.datasaver.api.controllers.forms;

public class AddLightLogForm {
	private float lux;
	
	public AddLightLogForm() {
	}

	public AddLightLogForm(float lux) {
		this.lux = lux;
	}

	public float getLux() {
		return lux;
	}

	public void setLux(float lux) {
		this.lux = lux;
	}	
}
