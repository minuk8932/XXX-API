package com.datasaver.api.services;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasaver.api.domains.TermOfService;
import com.datasaver.api.repositories.TermOfServiceRepository;
import com.datasaver.api.services.interfaces.TermOfServiceServiceInterface;

@Service("TermOfServiceService")
public class TermOfServiceService implements TermOfServiceServiceInterface {
	@Autowired
	TermOfServiceRepository tr;

	@Autowired
	EntityManager em;

	@Override
	public TermOfService findByIdx(long idx) {
		return tr.findOne(idx);
	}

	@Override
	public void save(TermOfService termOfService) {
		tr.save(termOfService);
	}

	@Override
	public void delete(TermOfService termOfService) {
		tr.delete(termOfService);
	}

	@Override
	public TermOfService findLastest() {
		Query q = em.createNativeQuery("SELECT * FROM TermOfService AS tos ORDER BY ts DESC LIMIT 1",
				TermOfService.class);

		try {
			return (TermOfService) q.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}
}