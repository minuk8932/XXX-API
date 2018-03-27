package com.xxx.api.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;
	
	@Column(name = "orderNumber", unique = true)
	private String orderNumber;
	
	@Column(name = "deliveryAddress")
	private String deliveryAddress;
	
	@Column(name = "payment")
	private Type payment;
	
	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;
	
	@ManyToOne
	@JoinColumn(name = "mid")		// MemberTable의 mid : 외래키가 있는쪽이 연관관계의 주인이므로
	@JsonIgnore
	private Member mid;	
	
	// TODO : delivery number OneToOne join, how to?
	
	public enum Type {
		CREDIT_CARD(0), MASTER_CARD(1), ACCOUNT_TRANSFER(2), VIRTUAL_ACCOUNT(3), MOBILE(4), PAYCO(5);

		private int method;

		private Type(int method) {
			this.method = method;
		}

		public int getCode() {
			return method;
		}
	}
	
	public Order() {
	}

	public Order(long idx, String orderNumber, String deliveryAddress, Type payment, Timestamp ts, Member mid) {
		this.idx = idx;
		this.orderNumber = orderNumber;
		this.deliveryAddress = deliveryAddress;
		this.payment = payment;
		this.ts = ts;
		this.mid = mid;
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Type getPayment() {
		return payment;
	}

	public void setPayment(Type payment) {
		this.payment = payment;
	}

	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

	public Member getMid() {
		return mid;
	}

	public void setMid(Member mid) {
		this.mid = mid;
	}
}
