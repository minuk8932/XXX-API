package com.datasaver.api.controllers.forms;

import com.datasaver.api.domains.DeviceBatteryLog;
import com.datasaver.api.domains.DeviceBatteryLog.ChargeType;

public class AddBatteryLogForm {
	private DeviceBatteryLog.ChargeType chargeType;
	private float percent;
	
	public AddBatteryLogForm() {
	}

	public AddBatteryLogForm(ChargeType chargeType, float percent) {
		this.chargeType = chargeType;
		this.percent = percent;
	}

	public DeviceBatteryLog.ChargeType getChargeType() {
		return chargeType;
	}

	public void setChargeType(DeviceBatteryLog.ChargeType chargeType) {
		this.chargeType = chargeType;
	}

	public float getPercent() {
		return percent;
	}

	public void setPercent(float percent) {
		this.percent = percent;
	}
}
