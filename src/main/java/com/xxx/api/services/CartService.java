package com.xxx.api.services;

import java.util.Collection;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.api.domains.Cart;
import com.xxx.api.domains.Product;
import com.xxx.api.repositories.CartRepository;
import com.xxx.api.services.interfaces.CartServiceInterface;

@Service("CartService")
public class CartService implements CartServiceInterface{
	@Autowired
	private CartRepository cr;
	
	@Autowired
	private EntityManager em;
	
	@Override
	public Cart findByIdx(long idx) {
		return cr.findOne(idx);
	}

	@Override
	public void save(Cart cart) {
		cr.save(cart);
	}

	@Override
	public void delete(Cart cart) {
		cr.delete(cart);
	}

	@Override
	public Collection<Product> findList(Cart cartList) {
		return null;
	}
}
