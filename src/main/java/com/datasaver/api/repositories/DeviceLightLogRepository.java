package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datasaver.api.domains.DeviceLightLog;

@Repository
public interface DeviceLightLogRepository extends JpaRepository<DeviceLightLog, Long> {
}
