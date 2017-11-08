package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datasaver.api.domains.DeviceBaseStationLog;

public interface DeviceBaseStationLogRepository extends JpaRepository<DeviceBaseStationLog, Long> {
}
