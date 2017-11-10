package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datasaver.api.domains.Help;

@Repository
public interface HelpRepository extends JpaRepository<Help, Long> {
}
