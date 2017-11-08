package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datasaver.api.domains.DeviceBatteryLog;

public interface DeviceBatteryLogRepository extends JpaRepository<DeviceBatteryLog, Long> {
}
