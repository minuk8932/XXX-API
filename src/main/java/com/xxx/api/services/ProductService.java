package com.xxx.api.services;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.api.domains.Product;
import com.xxx.api.repositories.ProductRepository;
import com.xxx.api.services.interfaces.ProductServiceInterface;

@Service("ProductService")
public class ProductService implements ProductServiceInterface{
	@Autowired
	ProductRepository pr;
	
	@Autowired
	EntityManager em;
	
	@Override
	public Product findByIdx(long idx) {
		return pr.findOne(idx);
	}

	@Override
	public Product findByProductName(String productName) {
		return pr.findByProductName(productName);
	}

	@Override
	public Product findByProductCode(String productCode) {
		return pr.findByProductCode(productCode);
	}

	@Override
	public Product findByPrice(int price) {
		return pr.findByPrice(price);
	}

	@Override
	public Product findByStock(int stock) {
		return pr.findByStock(stock);
	}

	@Override
	public void save(Product product) {
		pr.save(product);
	}

	@Override
	public void delete(Product product) {
		pr.delete(product);
	}
	
}
