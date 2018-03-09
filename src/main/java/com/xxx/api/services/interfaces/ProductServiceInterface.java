package com.xxx.api.services.interfaces;

import com.xxx.api.domains.Product;

public interface ProductServiceInterface {
	public Product findByIdx(long idx);
	
	public Product findByProductName(String productName);
	
	public Product findByProductCode(String productCode);
	
	public Product findByPrice(int price);
	
	public Product findByStock(int stock);
	
	public void save(Product product);
	
	public void delete(Product product);
}
