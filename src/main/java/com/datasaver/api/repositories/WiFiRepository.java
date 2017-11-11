package com.datasaver.api.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.datasaver.api.domains.User;
import com.datasaver.api.domains.WiFi;

@Repository
public interface WiFiRepository extends JpaRepository<WiFi, Long> {
	@Query("SELECT w FROM WiFi AS w WHERE w.user = ?1")
	public WiFi findByUser(User user);

	@Query("SELECT w FROM WiFi AS w WHERE w.user = ?1 AND w.mac = ?2")
	public WiFi findByUserNMac(User user, String mac);

	@Query("SELECT w FROM WiFi AS w WHERE w.user = ?1")
	public Collection<WiFi> findMyListByUser(User user);
}