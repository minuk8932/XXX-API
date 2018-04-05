package com.xxx.api.services.interfaces;

import java.util.Collection;

import com.xxx.api.domains.Cart;
import com.xxx.api.domains.Product;

public interface CartServiceInterface {
	public Cart findByIdx(long idx);

	public void save(Cart cart);

	public void delete(Cart cart);

	public Collection<Product> findList(Cart cartList);
}
