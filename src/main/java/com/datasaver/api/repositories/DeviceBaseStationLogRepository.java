package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datasaver.api.domains.DeviceBaseStationLog;

@Repository
public interface DeviceBaseStationLogRepository extends JpaRepository<DeviceBaseStationLog, Long> {
}