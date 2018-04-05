package com.xxx.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xxx.api.domains.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
}
