package com.xxx.api.services.interfaces;

import com.xxx.api.domains.Lookbook;

public interface LookbookServiceInterface {
	public Lookbook findByIdx(long idx);
	
	public Lookbook findByImageName(String imageName);
	
	
	
	// need find view
}
