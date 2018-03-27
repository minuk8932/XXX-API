package com.xxx.api.domains.view;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FindOrderListView {
	@Id
	private long idx;
	private String orderNumber;
	private String productImg;
	
	public FindOrderListView() {
	}

	public FindOrderListView(long idx, String orderNumber, String productImg) {
		this.idx = idx;
		this.orderNumber = orderNumber;
		this.productImg = productImg;
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

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
}
