package com.xxx.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xxx.api.domains.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	@Query("SELECT m FROM Member AS m WHERE m.email = ?1")
	public Member findByEmail(String email);
	
	@Query("SELECT m FROM Member AS m WHERE m.phoneNumber = ?1")
	public Member findByPhoneNumber(String phoneNumber);
}
