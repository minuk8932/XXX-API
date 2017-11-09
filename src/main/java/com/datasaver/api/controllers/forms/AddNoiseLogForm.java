package com.datasaver.api.controllers.forms;

public class AddNoiseLogForm {
	private double db;
	
	public AddNoiseLogForm() {
	}
	
	public AddNoiseLogForm(double db) {
		this.db = db;
	}

	public double getDb() {
		return db;
	}

	public void setDb(double db) {
		this.db = db;
	}	
}
