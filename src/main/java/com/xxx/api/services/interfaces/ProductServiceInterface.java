package com.xxx.api.services.interfaces;

import com.xxx.api.domains.Product;

public interface ProductServiceInterface {
	public Product findByIdx(long idx);
	
	public Product findByName(String name);
	
	public void save(Product category);
	
	public void delete(Product category);
	
}
