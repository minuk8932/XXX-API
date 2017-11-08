package com.datasaver.api.services.interfaces;

import com.datasaver.api.domains.DeviceNoiseLog;

public interface DeviceNoiseLogServiceInterface {
	public DeviceNoiseLog findByIdx(long idx);
	
	public void save(DeviceNoiseLog deviceNoiseLog);
	
	public void delete(DeviceNoiseLog deviceNoiseLog);
}
