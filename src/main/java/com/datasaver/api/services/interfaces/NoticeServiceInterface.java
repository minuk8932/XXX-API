package com.datasaver.api.services.interfaces;

import com.datasaver.api.domains.Notice;

public interface NoticeServiceInterface {
	public Notice findByIdx(long idx);
	
	public void save(Notice notice);
	
	public void delete(Notice notice);
	
	public Notice findByTitleNContents(String title, String contents);
}
