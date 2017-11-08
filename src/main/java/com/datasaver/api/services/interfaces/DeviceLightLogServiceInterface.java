package com.datasaver.api.services.interfaces;

import com.datasaver.api.domains.DeviceLightLog;

public interface DeviceLightLogServiceInterface {
	public DeviceLightLog findByIdx(long idx);
	
	public void save(DeviceLightLog deviceLightLog);
	
	public void delete(DeviceLightLog deviceLightLog);
}
