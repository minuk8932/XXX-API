package com.xxx.api.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;
	
	@Column(name = "productCode")
	private String productCode;
	
	@Column(name = "productName")
	private String productName;
	
	@Column(name = "size")
	private Size size;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "contents")
	private String contents;
	
	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;
	
	@ManyToOne
	@JoinColumn(name = "pidx")	
	private Category category;
	
	public enum Size {
		SMALL("S"), MEDIUM("M"), LARGE("L"), X_LARGE("XL");

		private String size;

		private Size(String size) {
			this.size = size;
		}

		public String getSize() {
			return size;
		}
	}
	
	public Product(){
	}

	public Product(long idx, String productCode, String productName, Size size, String price, String contents,
			Timestamp ts, Category category) {
		this.idx = idx;
		this.productCode = productCode;
		this.productName = productName;
		this.size = size;
		this.price = price;
		this.contents = contents;
		this.ts = ts;
		this.category = category;
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
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

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
