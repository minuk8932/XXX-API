package com.datasaver.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasaver.api.domains.DeviceTiltLog;
import com.datasaver.api.repositories.DeviceTiltLogRepository;
import com.datasaver.api.services.interfaces.DeviceTiltLogServiceInterface;

@Service("DeviceTiltLogService")
public class DeviceTiltLogService implements DeviceTiltLogServiceInterface{
	@Autowired
	private DeviceTiltLogRepository dtlr;

	@Override
	public DeviceTiltLog findByIdx(long idx) {
		return dtlr.findOne(idx);
	}

	@Override
	public void save(DeviceTiltLog deviceTiltLog) {
		dtlr.save(deviceTiltLog);
	}

	@Override
	public void delete(DeviceTiltLog deviceTiltLog) {
		dtlr.delete(deviceTiltLog);
	}
}
