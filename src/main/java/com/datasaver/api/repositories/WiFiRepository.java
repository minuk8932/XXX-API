package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datasaver.api.domains.WiFi;

@Repository
public interface WiFiRepository extends JpaRepository<WiFi, Long> {
}