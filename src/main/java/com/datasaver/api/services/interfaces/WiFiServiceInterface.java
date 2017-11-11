package com.datasaver.api.services.interfaces;

import java.util.Collection;

import com.datasaver.api.domains.User;
import com.datasaver.api.domains.WiFi;

public interface WiFiServiceInterface {
	public WiFi findByIdx(long idx);

	public void save(WiFi wifi);

	public void delete(WiFi wifi);

	public WiFi findByUser(User user);

	public WiFi findByMac(String mac);

	public WiFi findMostRecentlyUsedByUidx(long uidx);

	public Collection<WiFi> findListByUser(User user);
}
