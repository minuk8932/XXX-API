package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datasaver.api.domains.PushMessage;

@Repository
public interface PushMessageRepository extends JpaRepository<PushMessage, Long> {
}