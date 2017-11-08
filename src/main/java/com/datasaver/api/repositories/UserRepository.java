package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datasaver.api.domains.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
