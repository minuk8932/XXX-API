package com.xxx.api.services;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.api.domains.Member;
import com.xxx.api.domains.Order;
import com.xxx.api.domains.view.OrderProductView;
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

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Order> findOrderListByMemeberIdx(Order midx) {
		Query q = em.createNativeQuery(
				"SELECT o.orderNumber FROM ORDER AS o INNER JOIN MEMBER AS m ON m.idx = o.midx ORDER BY m.idx ASC LIMIT 1",
				OrderProductView.class);
		q.setParameter(1, midx);

		return (ArrayList<Order>) q.getResultList();
	}
}
