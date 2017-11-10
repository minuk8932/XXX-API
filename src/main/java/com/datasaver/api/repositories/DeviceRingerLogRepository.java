package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datasaver.api.domains.DeviceRingerLog;

@Repository
public interface DeviceRingerLogRepository extends JpaRepository<DeviceRingerLog, Long> {
}
