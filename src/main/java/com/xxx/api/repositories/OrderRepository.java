package com.xxx.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xxx.api.domains.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	@Query("SELECT o FROM Order AS o WHERE o.orderNumber = ?1")
	public Order findByOrderNumber(String orderNumber);
	
	@Query("SELECT o FROM Order AS o WHERE o.deliveryAddress = ?1")
	public Order findByDeliveryAddress(String deliveryAddress);
	
	// how to orderList..
}
