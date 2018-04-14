package com.xxx.api.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;
	
	@Column(name = "order_number", unique = true)
	private String orderNumber;
	
	@Column(name = "payment")
	private Type payment;
	
	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;
	
	// 연결 테이블 설정
	@ManyToOne
	@JoinColumn(name = "member_idx")
	@JsonIgnore
	private Member midx;
	
	@OneToOne(fetch = FetchType.LAZY)					// 1:1 단방향
	@JoinColumn(name = "member_address", nullable = false)
	private Member deliveryAddress;
	
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

	public Order(long idx, String orderNumber, Type payment, Timestamp ts, Member midx, Member deliveryAddress) {
		this.idx = idx;
		this.orderNumber = orderNumber;
		this.payment = payment;
		this.ts = ts;
		this.midx = midx;
		this.deliveryAddress = deliveryAddress;
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

	public Member getMidx() {
		return midx;
	}

	public void setMidx(Member midx) {
		this.midx = midx;
	}

	public Member getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Member deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
}
