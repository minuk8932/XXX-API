package com.datasaver.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasaver.api.domains.Help;
import com.datasaver.api.repositories.HelpRepository;
import com.datasaver.api.services.interfaces.HelpServiceInterface;

@Service("HelpService")
public class HelpService implements HelpServiceInterface{
	@Autowired
	HelpRepository hr;
	
	@Override
	public Help findByIdx(long idx) {
		return hr.findOne(idx);
	}

	@Override
	public void save(Help help) {
		hr.save(help);
	}

	@Override
	public void delete(Help help) {
		hr.save(help);
	}

	@Override
	public Help findByTitleNContents(String title, String contents) {
		return hr.findByTitleNContents(title, contents);
	}
}
