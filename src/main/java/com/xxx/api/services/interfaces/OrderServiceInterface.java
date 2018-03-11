package com.xxx.api.services.interfaces;

import com.xxx.api.domains.Order;

public interface OrderServiceInterface {
	public Order findByIdx(long idx);
	
	public Order findByOrderNumber(String orderNumber);
	
	public Order findByDeliveryAddress(String deliveryAddress);
	
	public void save(Order order);
	
	public void delete(Order order);
}
