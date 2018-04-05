package com.xxx.api.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;
	
	@Column(name = "category")
	private Category category;
	
	@Column(name = "productImg")
	private String productImg;
	
	@Column(name = "productCode")
	private String productCode;
	
	@Column(name = "productName")
	private String productName;
	
	@Column(name = "size")
	private Size size;
	
	@Column(name = "price", nullable = false)
	private int price;
	
	@Column(name = "stock")
	private int stock;
	
	@Column(name = "contents")
	private String contents;
	
	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;
	
	public enum Category {
		TOP("Top"), BOTTOM("Bottom"), OUTER("Outer"), Accessory("accessory");

		private String category;

		private Category(String category) {
			this.category = category;
		}

		public String getCategory() {
			return category;
		}
	}
	
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

	public Product(long idx, Category category, String productImg, String productCode, String productName, Size size,
			int price, int stock, String contents, Timestamp ts) {
		this.idx = idx;
		this.category = category;
		this.productImg = productImg;
		this.productCode = productCode;
		this.productName = productName;
		this.size = size;
		this.price = price;
		this.stock = stock;
		this.contents = contents;
		this.ts = ts;
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
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
}
