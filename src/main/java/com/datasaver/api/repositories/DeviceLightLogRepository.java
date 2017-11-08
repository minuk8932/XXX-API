package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datasaver.api.domains.DeviceLightLog;

public interface DeviceLightLogRepository extends JpaRepository<DeviceLightLog, Long> {
}
