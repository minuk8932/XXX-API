package com.datasaver.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.datasaver.api.domains.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User AS u WHERE u.email = ?1 AND u.password = ?2")
	public User getUserByEmailNPassword(String email, String password);

	@Query("SELECT u FROM User AS u WHERE u.name = ?1 AND u.phoneNumber = ?2")
	public User getUserByNameNPhoneNumber(String name, String phoneNumber);
}