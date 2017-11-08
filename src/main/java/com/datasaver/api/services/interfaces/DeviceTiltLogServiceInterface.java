package com.datasaver.api.services.interfaces;

import com.datasaver.api.domains.DeviceTiltLog;

public interface DeviceTiltLogServiceInterface {
	public DeviceTiltLog findByIdx(long idx);
	
	public void save(DeviceTiltLog deviceTiltLog);
	
	public void delete(DeviceTiltLog deviceTiltLog);
}
