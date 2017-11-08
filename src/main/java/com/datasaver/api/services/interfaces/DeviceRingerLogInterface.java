package com.datasaver.api.services.interfaces;

import com.datasaver.api.domains.DeviceRingerLog;

public interface DeviceRingerLogInterface {
	public DeviceRingerLog findByIdx(long idx);
	
	public void save(DeviceRingerLog deviceRingerLog);
	
	public void delete(DeviceRingerLog deviceRingerLog);
}
