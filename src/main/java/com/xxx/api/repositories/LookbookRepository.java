package com.xxx.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xxx.api.domains.Lookbook;

@Repository
public interface LookbookRepository extends JpaRepository<Lookbook, Long>{
}
