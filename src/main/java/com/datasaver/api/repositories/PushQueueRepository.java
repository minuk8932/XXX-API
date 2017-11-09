package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datasaver.api.domains.PushQueue;

public interface PushQueueRepository extends JpaRepository<PushQueue, Long> {
}