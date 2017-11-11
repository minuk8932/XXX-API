package com.datasaver.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasaver.api.domains.Notice;
import com.datasaver.api.repositories.NoticeRepository;
import com.datasaver.api.services.interfaces.NoticeServiceInterface;

@Service("NoticeService")
public class NoticeService implements NoticeServiceInterface{
	@Autowired
	NoticeRepository nr;
	
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
		nr.save(notice);
	}

	@Override
	public Notice findByTitleNContents(String title, String contents) {
		return nr.findByTitleNContents(title, contents);
	}
}
