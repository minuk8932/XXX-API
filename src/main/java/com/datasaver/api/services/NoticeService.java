package com.datasaver.api.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.datasaver.api.domains.Notice;
import com.datasaver.api.repositories.NoticeRepository;
import com.datasaver.api.services.interfaces.NoticeServiceInterface;

@Service("NoticeService")
public class NoticeService implements NoticeServiceInterface {
	private static final int PAGE_SIZE = 20;

	@Autowired
	NoticeRepository nr;

	@Override
	public Notice findByIdx(long idx) {
		return nr.findOne(idx);
	}

	@Override
	public Notice save(Notice notice) {
		return nr.save(notice);
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