package com.xxx.api.services;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.api.domains.Order;
import com.xxx.api.repositories.OrderRepository;
import com.xxx.api.services.interfaces.OrderServiceInterface;

@Service("OrderService")
public class OrderService implements OrderServiceInterface{
	@Autowired
	OrderRepository or;
	
	@Autowired
	EntityManager em;
	
	@Override
	public Order findByIdx(long idx) {
		return or.findOne(idx);
	}

	@Override
	public Order findByOrderNumber(String orderNumber) {
		return or.findByOrderNumber(orderNumber);
	}

	@Override
	public Order findByDeliveryAddress(String deliveryAddress) {
		return or.findByDeliveryAddress(deliveryAddress);
	}

	@Override
	public void save(Order order) {
		or.save(order);
	}

	@Override
	public void delete(Order order) {
		or.delete(order);
	}
	
	// how to orderList...
}
