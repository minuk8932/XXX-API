package com.xxx.api.services;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.api.domains.Lookbook;
import com.xxx.api.repositories.LookbookRepository;
import com.xxx.api.services.interfaces.LookbookServiceInterface;

@Service("Lookbook")
public class LookbookService implements LookbookServiceInterface{
	
	@Autowired
	LookbookRepository lr;
	
	@Autowired
	EntityManager em;
	
	@Override
	public Lookbook findByIdx(long idx) {
		return lr.findOne(idx);
	}

	@Override
	public void save(Lookbook lookbook) {
		lr.save(lookbook);
	}

	@Override
	public void delete(Lookbook lookbook) {
		lr.delete(lookbook);
	}

}
