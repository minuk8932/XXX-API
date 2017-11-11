package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.datasaver.api.domains.Help;

@Repository
public interface HelpRepository extends JpaRepository<Help, Long> {
	@Query("SELECT h FROM Help AS h WHERE h.title = ?1 AND h.contents = ?2")
	public Help findByTitleNContents(String title, String contents);
}
