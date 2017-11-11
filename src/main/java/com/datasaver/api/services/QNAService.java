package com.datasaver.api.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.datasaver.api.domains.QNA;
import com.datasaver.api.repositories.QNARepository;
import com.datasaver.api.services.interfaces.QNAServiceInterface;

@Service("QNAService")
public class QNAService implements QNAServiceInterface{
	private static final int PAGE_SIZE = 20;
	
	@Autowired
	QNARepository qr;
	
	@Override
	public QNA findByIdx(long idx) {
		return qr.findOne(idx);
	}

	@Override
	public void save(QNA qna) {
		qr.save(qna);
	}

	@Override
	public void delete(QNA qna) {
		qr.delete(qna);
	}

	@Override
	public Collection<QNA> findList(int page) {
		return qr.findList(new PageRequest(page, PAGE_SIZE)).getContent();
	}

}
