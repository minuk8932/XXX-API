package com.datasaver.api.services.interfaces;

import com.datasaver.api.domains.DeviceLocationLog;

public interface DeviceLocationLogInterface {
	public DeviceLocationLog findByIdx(long idx);
	
	public void save(DeviceLocationLog deviceLocationLog);
	
	public void delete(DeviceLocationLog deviceLocationLog);
}
