package com.datasaver.api.services.interfaces;

import com.datasaver.api.domains.WiFiConnectionLog;

public interface WiFiConnectionLogServiceInterface {
	public WiFiConnectionLog findByIdx(long idx);
	
	public void save(WiFiConnectionLog wifiConnectionLog);
	
	public void delete(WiFiConnectionLog wifiConnectionLog);
}
