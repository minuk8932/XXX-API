package com.xxx.api.services.interfaces;

import com.xxx.api.domains.TermsOfService;

public interface TermsOfServiceServiceInterface {
	public TermsOfService findByIdx(long idx);
	
	public void save(TermsOfService termOfService);
	
	public void delete(TermsOfService termOfService);
	
	public TermsOfService findLastest();
}
