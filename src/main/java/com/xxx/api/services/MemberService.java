package com.xxx.api.services;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasaver.api.domains.WiFi;
import com.datasaver.api.domains.views.FindFriendWiFiView;
import com.xxx.api.domains.Member;
import com.xxx.api.domains.Order;
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
	public ArrayList<Order> findOrderListByMemeberIdx(Member midx) {
		Query q = em.createNativeQuery(
				"SELECT w.idx, w.ssid, w.longitude, w.latitude FROM WiFi AS w INNER JOIN WiFiConnectionLog AS wcl ON w.idx = wcl.widx WHERE w.uidx = ? AND wcl.type = 1 ORDER BY wcl.ts DESC LIMIT 1",
				FindFriendWiFiView.class);
		q.setParameter(1, midx);

		return (ArrayList<Order>) q.getResultList();
	}
}
