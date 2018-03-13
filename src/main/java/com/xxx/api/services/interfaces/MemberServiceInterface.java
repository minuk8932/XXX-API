package com.xxx.api.services.interfaces;

import com.xxx.api.domains.Member;

public interface MemberServiceInterface {
	public Member fingByIdx(long idx);
	
	public Member findByEmail(String email);
	
	public Member findByPhoneNumber(String phoneNumber);
	
	public void save(Member member);
	
	public void delete(Member member);
	
//	public Collection<Order> findOrderListByIdx(long[] idxs, int page);
}
