package com.datasaver.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasaver.api.domains.DeviceLocationLog;
import com.datasaver.api.repositories.DeviceLocationLogRepository;
import com.datasaver.api.services.interfaces.DeviceLocationLogServiceInterface;

@Service("DeviceLocationLogService")
public class DeviceLocationLogService implements DeviceLocationLogServiceInterface{
	@Autowired
	private DeviceLocationLogRepository dllr;

	@Override
	public DeviceLocationLog findByIdx(long idx) {
		return dllr.findOne(idx);
	}

	@Override
	public void save(DeviceLocationLog deviceLocationLog) {
		dllr.save(deviceLocationLog);
	}

	@Override
	public void delete(DeviceLocationLog deviceLocationLog) {
		dllr.delete(deviceLocationLog);
	}
}
