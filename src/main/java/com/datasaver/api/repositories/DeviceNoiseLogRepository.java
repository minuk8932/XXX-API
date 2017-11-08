package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datasaver.api.domains.DeviceNoiseLog;

public interface DeviceNoiseLogRepository extends JpaRepository<DeviceNoiseLog, Long> {
}
