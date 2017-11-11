package com.datasaver.api.services.interfaces;

import java.util.Collection;

import com.datasaver.api.domains.Notice;

public interface NoticeServiceInterface {
	public Notice findByIdx(long idx);

	public Notice save(Notice notice);

	public void delete(Notice notice);

	public Collection<Notice> findList(int page);
}
