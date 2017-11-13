package com.datasaver.api.services.interfaces;

import com.datasaver.api.domains.TermOfService;

public interface TermOfServiceServiceInterface {
	public TermOfService findByIdx(long idx);
	
	public void save(TermOfService termOfService);
	
	public void delete(TermOfService termOfService);
	
	public TermOfService findLastest();
}
