package com.datasaver.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datasaver.api.domains.PushMessage;
import com.datasaver.api.domains.User;

@Repository
public interface PushMessageRepository extends JpaRepository<PushMessage, Long> {
	public Page<PushMessage> findListByUser(User user, Pageable pageable);
}