package com.xxx.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xxx.api.domains.TermsOfService;

@Repository
public interface TermsOfServiceRepository extends JpaRepository<TermsOfService, Long>{

}
