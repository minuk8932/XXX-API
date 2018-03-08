package com.xxx.api.services;

import java.util.Collection;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.api.domains.Member;
import com.xxx.api.domains.Order;
import com.xxx.api.domains.QNA;
import com.xxx.api.repositories.MemberRepository;
import com.xxx.api.services.interfaces.MemberServiceInterface;

@Service("MemberService")
public class MemberService implements MemberServiceInterface{
	@Autowired
	MemberRepository mr;
	
	@Autowired
	EntityManager em;
	
	@Override
	public Member fingByIdx(long idx) {
		return mr.findOne(idx);
	}

	@Override
	public Member findByEmail(String email) {
		return mr.findByEmail(email);
	}

	@Override
	public Member findByPhoneNumber(String phoneNumber) {
		return mr.findByPhoneNumber(phoneNumber);
	}

	@Override
	public void save(Member member) {
		mr.save(member);
	}

	@Override
	public void delete(Member member) {
		mr.delete(member);
	}
	
	@Override
	public Collection<Order> findOrderListAll() {
//		return or.findAll();
		return null;
	}

	@Override
	public Collection<Order> findOrderListByIdx(long[] idxs) {
		return mr.findOrderListByIdx(idxs);
	}
	
	@Override
	public Collection<QNA> findQNAListAll() {
//		return qr.findAll();
		return null;
	}

	@Override
	public Collection<QNA> findQNAListByIdx(long[] idxs) {
		return mr.findQNAListByIdx(idxs);
	}
}
