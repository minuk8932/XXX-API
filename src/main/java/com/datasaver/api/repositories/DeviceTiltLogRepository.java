package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datasaver.api.domains.DeviceTiltLog;

@Repository
public interface DeviceTiltLogRepository extends JpaRepository<DeviceTiltLog, Long> {
}
