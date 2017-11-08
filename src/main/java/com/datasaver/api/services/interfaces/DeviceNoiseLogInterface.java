package com.datasaver.api.services.interfaces;

import com.datasaver.api.domains.DeviceNoiseLog;

public interface DeviceNoiseLogInterface {
	public DeviceNoiseLog findByIdx(long idx);
	
	public void save(DeviceNoiseLog deviceNoiseLog);
	
	public void delete(DeviceNoiseLog deviceNoiseLog);
}
