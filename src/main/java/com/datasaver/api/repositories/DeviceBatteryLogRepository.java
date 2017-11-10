package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datasaver.api.domains.DeviceBatteryLog;

@Repository
public interface DeviceBatteryLogRepository extends JpaRepository<DeviceBatteryLog, Long> {
}
