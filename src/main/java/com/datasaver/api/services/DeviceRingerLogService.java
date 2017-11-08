package com.datasaver.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasaver.api.domains.DeviceRingerLog;
import com.datasaver.api.repositories.DeviceRingerLogRepository;
import com.datasaver.api.services.interfaces.DeviceRingerLogServiceInterface;

@Service("DeviceRingerLogService")
public class DeviceRingerLogService implements DeviceRingerLogServiceInterface{
	@Autowired
	private DeviceRingerLogRepository drlr;
	
	@Override
	public DeviceRingerLog findByIdx(long idx) {
		return drlr.findOne(idx);
	}

	@Override
	public void save(DeviceRingerLog deviceRingerLog) {
		drlr.save(deviceRingerLog);
	}

	@Override
	public void delete(DeviceRingerLog deviceRingerLog) {
		drlr.delete(deviceRingerLog);
	}
}
