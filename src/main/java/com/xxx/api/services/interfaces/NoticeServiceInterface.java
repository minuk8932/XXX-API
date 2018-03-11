package com.xxx.api.services.interfaces;

import java.util.Collection;

import com.xxx.api.domains.Notice;

public interface NoticeServiceInterface {
	public Notice findByIdx(long idx);

	public void save(Notice notice);

	public void delete(Notice notice);

	public Collection<Notice> findList(int page);
}

