package com.xxx.api.services.interfaces;

import com.xxx.api.domains.Lookbook;

public interface LookbookServiceInterface {
	public Lookbook findByIdx(long idx);
	
	public void save(Lookbook lookbook);
	
	public void delete(Lookbook lookbook);
	
	// need find view
}
