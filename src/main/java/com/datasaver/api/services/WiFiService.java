package com.datasaver.api.services;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasaver.api.domains.User;
import com.datasaver.api.domains.WiFi;
import com.datasaver.api.domains.views.FindFriendWiFiView;
import com.datasaver.api.repositories.WiFiRepository;
import com.datasaver.api.services.interfaces.WiFiServiceInterface;

@Service("WiFiService")
public class WiFiService implements WiFiServiceInterface {
	@Autowired
	private WiFiRepository wr;

	@Autowired
	private EntityManager em;

	@Override
	public WiFi findByIdx(long idx) {
		return wr.findOne(idx);
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

	@Override
	public WiFi findByUserNMac(User user, String mac) {
		return wr.findByUserNMac(user, mac);
	}

	@Override
	public WiFi findMostRecentlyUsedByUidx(long uidx) {
		Query q = em.createNativeQuery(
				"SELECT * FROM WiFi AS w INNER JOIN WiFiConnectionLog AS wcl ON w.idx = wcl.widx WHERE w.uidx = ? AND wcl.type = 1 ORDER BY wcl.ts DESC LIMIT 1",
				WiFi.class);
		q.setParameter(1, uidx);

		try {
			return (WiFi) q.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	@Override
	public Collection<WiFi> findMyListByUser(User user) {
		return wr.findMyListByUser(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<WiFi> findFriendListByUidx(long uidx) {
		Query q = em.createNativeQuery(
				"SELECT w.idx, w.ssid, w.longitude, w.latitude FROM WiFi AS w INNER JOIN WiFiConnectionLog AS wcl ON w.idx = wcl.widx WHERE w.uidx = ? AND wcl.type = 1 ORDER BY wcl.ts DESC LIMIT 1",
				FindFriendWiFiView.class);
		q.setParameter(1, uidx);

		return (Collection<WiFi>) q.getResultList();
	}
}