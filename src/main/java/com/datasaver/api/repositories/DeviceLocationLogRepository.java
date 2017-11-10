package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datasaver.api.domains.DeviceLocationLog;

@Repository
public interface DeviceLocationLogRepository extends JpaRepository<DeviceLocationLog, Long> {
}
