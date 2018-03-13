package com.xxx.api.services.interfaces;

import com.xxx.api.domains.TermOfService;

public interface TermOfServiceServiceInterface {
	public TermOfService findByIdx(long idx);
	
	public void save(TermOfService termOfService);
	
	public void delete(TermOfService termOfService);
	
	public TermOfService findLastest();
}
