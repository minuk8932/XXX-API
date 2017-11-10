package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.datasaver.api.domains.Device;
import com.datasaver.api.domains.User;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
	@Query("SELECT d FROM Device AS d WHERE d.user = ?")
	public Device findByUser(User user);
}