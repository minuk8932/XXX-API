package com.xxx.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xxx.api.domains.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	@Query("SELECT m FROM Product AS p WHERE p.productName = ?1")
	public Product findByProductName(String productName);
	
	@Query("SELECT p FROM Product AS p WHERE p.productCode = ?1")
	public Product findByProductCode(String productCode);
	
	@Query("SELECT p FROM Product AS p WHERE p.price = ?1")
	public Product findByPrice(int price);
	
	@Query("SELECT p FROM Product AS p WHERE p.stock = ?1")
	public Product findByStock(int stock);
	
}
