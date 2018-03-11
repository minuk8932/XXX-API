package com.xxx.api.services.interfaces;

import java.util.Collection;

import com.xxx.api.domains.Member;
import com.xxx.api.domains.Order;

public interface MemberServiceInterface {
	public Member fingByIdx(long idx);
	
	public Member findByEmail(String email);
	
	public Member findByPhoneNumber(String phoneNumber);
	
	public void save(Member member);
	
	public void delete(Member member);
	
//	public Collection<Order> findOrderListByIdx(long[] idxs, int page);
}
