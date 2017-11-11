package com.datasaver.api.services.interfaces;

import com.datasaver.api.domains.Help;

public interface HelpServiceInterface {
	public Help findByIdx(long idx);
	
	public void save(Help help);
	
	public void delete(Help help);
	
	public Help findByTitleNContents(String title, String contents);
}
