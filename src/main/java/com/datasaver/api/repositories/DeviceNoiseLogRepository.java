package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datasaver.api.domains.DeviceNoiseLog;

@Repository
public interface DeviceNoiseLogRepository extends JpaRepository<DeviceNoiseLog, Long> {
}
