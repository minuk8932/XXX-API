package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datasaver.api.domains.WiFi;

public interface WiFiRepository extends JpaRepository<WiFi, Long> {
}