package com.datasaver.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasaver.api.domains.WiFiConnectionLog;
import com.datasaver.api.repositories.WiFiConnectionLogRepository;
import com.datasaver.api.services.interfaces.WiFiConnectionLogServiceInterface;

@Service("WiFiConnectionService")
public class WiFiConnectionLogService implements WiFiConnectionLogServiceInterface{
	@Autowired
	private WiFiConnectionLogRepository wclr;

	@Override
	public WiFiConnectionLog findByIdx(long idx) {
		return wclr.findOne(idx);
	}

	@Override
	public void save(WiFiConnectionLog wifiConnectionLog) {
		wclr.save(wifiConnectionLog);
	}

	@Override
	public void delete(WiFiConnectionLog wifiConnectionLog) {
		wclr.delete(wifiConnectionLog);
	}
}