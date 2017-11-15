package com.datasaver.api.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.datasaver.api.domains.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User AS u WHERE u.email = ?1 AND u.password = ?2")
	public User findByEmailNPassword(String email, String password);

	@Query("SELECT u FROM User AS u WHERE u.name = ?1 AND u.phoneNumber = ?2")
	public User findByNameNPhoneNumber(String name, String phoneNumber);

	@Query("SELECT u FROM User AS u WHERE u.email = ?1")
	public User findByEmail(String email);

	@Query("SELECT u FROM User AS u WHERE u.phoneNumber = ?1")
	public User findByPhoneNumber(String phoneNumber);

	@Query("SELECT u FROM User AS u WHERE u.name = ?1 AND u.phoneNumber = ?2 AND u.email = ?3")
	public User findByNameNPhoneNumberNEmail(String name, String phoneNumber, String email);

	@Query("SELECT u FROM User AS u WHERE u.phoneNumber IN ?1")
	public Collection<User> findListByPhoneNumbers(String[] phoneNumbers);
}