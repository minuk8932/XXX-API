package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datasaver.api.domains.DeviceTiltLog;

public interface DeviceTiltLogRepository extends JpaRepository<DeviceTiltLog, Long> {
}
