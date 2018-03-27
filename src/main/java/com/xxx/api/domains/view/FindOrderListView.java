package com.xxx.api.domains.view;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FindOrderListView {
	@Id
	private long idx;
	private String orderNumber;
	private String productImg;
	private String productCode;
	private String productName;
	private String contents;
	private String size;
		
	public FindOrderListView() {
	}

	public FindOrderListView(long idx, String orderNumber, String productImg, String productCode, String productName,
			String contents, String size) {
		this.idx = idx;
		this.orderNumber = orderNumber;
		this.productImg = productImg;
		this.productCode = productCode;
		this.productName = productName;
		this.contents = contents;
		this.size = size;
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

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
}
