package com.datasaver.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasaver.api.domains.DeviceBatteryLog;
import com.datasaver.api.repositories.DeviceBatteryLogRepository;
import com.datasaver.api.services.interfaces.DeviceBatteryLogServiceInterface;

@Service("DeviceBatteryLogService")
public class DeviceBatteryLogService implements DeviceBatteryLogServiceInterface {
	@Autowired
	private DeviceBatteryLogRepository dblr;

	@Override
	public DeviceBatteryLog findByIdx(long idx) {
		return dblr.findOne(idx);
	}

	@Override
	public void save(DeviceBatteryLog deviceBatteryLog) {
		dblr.save(deviceBatteryLog);
	}

	@Override
	public void delete(DeviceBatteryLog deviceBatteryLog) {
		dblr.delete(deviceBatteryLog);
	}
}
