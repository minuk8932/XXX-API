package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datasaver.api.domains.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
