package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datasaver.api.domains.Help;

public interface HelpRepository extends JpaRepository<Help, Long> {
}
