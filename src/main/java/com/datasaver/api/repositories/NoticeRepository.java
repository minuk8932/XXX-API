package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datasaver.api.domains.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
