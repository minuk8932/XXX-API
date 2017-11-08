package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datasaver.api.domains.DeviceLocationLog;

public interface DeviceLocationLogRepository extends JpaRepository<DeviceLocationLog, Long> {
}
