package com.datasaver.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasaver.api.domains.User;
import com.datasaver.api.domains.WiFi;
import com.datasaver.api.repositories.WiFiRepository;
import com.datasaver.api.services.interfaces.WiFiServiceInterface;

@Service("WiFiService")
public class WiFiService implements WiFiServiceInterface{
	@Autowired
	WiFiRepository wr;
	
	@Override
	public WiFi findByIdx(long idx) {
		return wr.findOne(idx);
	}
	
	@Override
	public WiFi findBySsidNLongitudeNLatitude(String ssid, double longitude, double latitude) {
		return wr.findBySsidNLongitudeNLatitude(ssid, longitude, latitude);
	}

	@Override
	public void save(WiFi wifi) {
		wr.save(wifi);
	}

	@Override
	public void delete(WiFi wifi) {
		wr.delete(wifi);
	}
	
	@Override
	public WiFi findByUser(User user) {
		return wr.findByUser(user);
	}
}
