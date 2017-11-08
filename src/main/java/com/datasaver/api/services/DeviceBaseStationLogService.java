package com.datasaver.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasaver.api.domains.DeviceBaseStationLog;
import com.datasaver.api.repositories.DeviceBaseStationLogRepository;
import com.datasaver.api.services.interfaces.DeviceBaseStationLogServiceInterface;

@Service("DeviceBaseStationLog")
public class DeviceBaseStationLogService implements DeviceBaseStationLogServiceInterface {
	@Autowired
	private DeviceBaseStationLogRepository dbslr;

	@Override
	public DeviceBaseStationLog findByIdx(long idx) {
		return dbslr.findOne(idx);
	}

	@Override
	public void save(DeviceBaseStationLog deviceBaseStationLog) {
		dbslr.save(deviceBaseStationLog);
	}

	@Override
	public void delete(DeviceBaseStationLog deviceBaseStationLog) {
		dbslr.delete(deviceBaseStationLog);
	}
}
