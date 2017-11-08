package com.datasaver.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasaver.api.domains.DeviceNoiseLog;
import com.datasaver.api.repositories.DeviceNoiseLogRepository;
import com.datasaver.api.services.interfaces.DeviceNoiseLogServiceInterface;

@Service("DeviceNoiseLogService")
public class DeviceNoiseLogService implements DeviceNoiseLogServiceInterface{
	@Autowired
	private DeviceNoiseLogRepository dnlr;
	
	@Override
	public DeviceNoiseLog findByIdx(long idx) {
		return dnlr.findOne(idx);
	}

	@Override
	public void save(DeviceNoiseLog deviceNoiseLog) {
		dnlr.save(deviceNoiseLog);
	}

	@Override
	public void delete(DeviceNoiseLog deviceNoiseLog) {
		dnlr.delete(deviceNoiseLog);
	}
}
