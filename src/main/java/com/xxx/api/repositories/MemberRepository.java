package com.xxx.api.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xxx.api.domains.Member;
import com.xxx.api.domains.Order;
import com.xxx.api.domains.QNA;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	@Query("SELECT m FROM Member AS m WHERE m.email = ?1")
	public Member findByEmail(String email);
	
	@Query("SELECT m FROM Member AS m WHERE m.phoneNumber = ?1")
	public Member findByPhoneNumber(String phoneNumber);
	
	@Query("SELECT o FROM Order AS o WHERE o.idx = ?1")
	public Collection<Order> findOrderListByIdx(long[] idxs);
	
	@Query("SELECT q FROM QNA AS q WHERE q.idx = ?1")
	public Collection<QNA> findQNAListByIdx(long[] idxs);
}
