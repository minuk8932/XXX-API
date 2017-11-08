package com.datasaver.api.services.interfaces;

import com.datasaver.api.domains.DeviceLocationLog;

public interface DeviceLocationLogServiceInterface {
	public DeviceLocationLog findByIdx(long idx);
	
	public void save(DeviceLocationLog deviceLocationLog);
	
	public void delete(DeviceLocationLog deviceLocationLog);
}
