package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datasaver.api.domains.DeviceRingerLog;

public interface DeviceRingerLogRepository extends JpaRepository<DeviceRingerLog, Long> {
}
