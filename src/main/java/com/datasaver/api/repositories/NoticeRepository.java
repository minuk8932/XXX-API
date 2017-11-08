package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datasaver.api.domains.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
