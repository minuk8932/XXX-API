package com.datasaver.api.services.interfaces;

import java.util.Collection;

import com.datasaver.api.domains.QNA;

public interface QNAServiceInterface {
	public QNA findByIdx(long idx);
	
	public void save(QNA qna);
	
	public void delete(QNA qna);
	
	public Collection<QNA> findList(int page);
}
