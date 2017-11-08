package com.datasaver.api.services.interfaces;

import com.datasaver.api.domains.DeviceBatteryLog;

public interface DeviceBatteryLogServiceInterface {
	public DeviceBatteryLog findByIdx(long idx);
	
	public void save(DeviceBatteryLog deviceBatteryLog);
	
	public void delete(DeviceBatteryLog deviceBatteryLog);
}
