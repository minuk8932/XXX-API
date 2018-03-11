package com.xxx.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xxx.api.domains.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long>{
	@Query("SELECT n FROM Notice AS n")
	public Page<Notice> findList(Pageable pageable);
}
