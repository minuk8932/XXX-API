package com.datasaver.api.services.interfaces;

import com.datasaver.api.domains.User;
import com.datasaver.api.domains.WiFi;

public interface WiFiServiceInterface {
	public WiFi findByIdx(long idx);
	
	public WiFi findBySsidNLongitudeNLatitude(String ssid, double longitude, double latitude);
	
	public void save(WiFi wifi);
	
	public void delete(WiFi wifi);
	
	public WiFi findByUser(User user);
}