package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.datasaver.api.domains.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
	@Query("SELECT n FROM Notice AS n WHERE n.title = ?1 AND n.contents = ?2")
	public Notice findByTitleNContents(String title, String contents);
}
