package com.xxx.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xxx.api.domains.TermOfService;

@Repository
public interface TermOfServiceRepository extends JpaRepository<TermOfService, Long>{

}
