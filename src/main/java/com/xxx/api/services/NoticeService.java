package com.xxx.api.services;

import java.util.Collection;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.xxx.api.domains.Notice;
import com.xxx.api.repositories.NoticeRepository;
import com.xxx.api.services.interfaces.NoticeServiceInterface;

public class NoticeService implements NoticeServiceInterface{
	private static final int PAGE_SIZE = 10;
	
	@Autowired
	NoticeRepository nr;
	
	@Autowired
	EntityManager em;
	
	@Override
	public Notice findByIdx(long idx) {
		return nr.findOne(idx);
	}

	@Override
	public void save(Notice notice) {	
		nr.save(notice);
	}

	@Override
	public void delete(Notice notice) {
		nr.delete(notice);
	}

	@Override
	public Collection<Notice> findList(int page) {
		return nr.findList(new PageRequest(page, PAGE_SIZE, new Sort(Direction.DESC, "ts"))).getContent();
	}

}
