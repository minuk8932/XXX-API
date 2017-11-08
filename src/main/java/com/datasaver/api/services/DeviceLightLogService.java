package com.datasaver.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasaver.api.domains.DeviceLightLog;
import com.datasaver.api.repositories.DeviceLightLogRepository;
import com.datasaver.api.services.interfaces.DeviceLightLogServiceInterface;

@Service("DeviceLightLogService")
public class DeviceLightLogService implements DeviceLightLogServiceInterface{
	@Autowired
	private DeviceLightLogRepository dllr;

	@Override
	public DeviceLightLog findByIdx(long idx) {
		return dllr.findOne(idx);
	}

	@Override
	public void save(DeviceLightLog deviceLightLog) {
		dllr.save(deviceLightLog);
	}

	@Override
	public void delete(DeviceLightLog deviceLightLog) {
		dllr.delete(deviceLightLog);
	}
}
