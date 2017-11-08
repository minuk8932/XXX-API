package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datasaver.api.domains.WiFiConnectionLog;

public interface WiFiConnectionLogRepository extends JpaRepository<WiFiConnectionLog, Long> {
}
