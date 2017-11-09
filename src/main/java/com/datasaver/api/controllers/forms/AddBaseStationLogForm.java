package com.datasaver.api.controllers.forms;

public class AddBaseStationLogForm {
	private int cid;
	private int lac;

	public AddBaseStationLogForm() {
	}

	public AddBaseStationLogForm(int cid, int lac) {
		this.cid = cid;
		this.lac = lac;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getLac() {
		return lac;
	}

	public void setLac(int lac) {
		this.lac = lac;
	}
}