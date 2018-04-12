package com.xxx.api.services;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.api.domains.TermsOfService;
import com.xxx.api.repositories.TermsOfServiceRepository;
import com.xxx.api.services.interfaces.TermsOfServiceServiceInterface;

@Service("TermsOfService")
public class TermsOfServiceService implements TermsOfServiceServiceInterface{
	
	@Autowired
	TermsOfServiceRepository tr;
	
	@Autowired
	EntityManager em;

	@Override
	public TermsOfService findByIdx(long idx) {
		return tr.findOne(idx);
	}

	@Override
	public void save(TermsOfService termOfService) {
		tr.save(termOfService);
	}

	@Override
	public void delete(TermsOfService termOfService) {
		tr.delete(termOfService);
	}

	@Override
	public TermsOfService findLastest() {
		Query q = em.createNativeQuery("SELECT * FROM TermsOfService AS tos ORDER BY ts DESC LIMIT 1",
				TermsOfService.class);

		try {
			return (TermsOfService) q.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

}
