package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datasaver.api.domains.WiFiConnectionLog;

@Repository
public interface WiFiConnectionLogRepository extends JpaRepository<WiFiConnectionLog, Long> {
}
