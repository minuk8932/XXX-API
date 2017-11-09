package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.datasaver.api.domains.Device;
import com.datasaver.api.domains.User;

public interface DeviceRepository extends JpaRepository<Device, Long> {
	@Query("SELECT d FROM Device AS d WHERE d.user = ?")
	public Device findByUser(User user);
}