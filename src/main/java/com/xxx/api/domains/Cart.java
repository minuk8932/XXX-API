package com.xxx.api.domains;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;
	
	@Column(name = "statusSet")
	private StatusSet statusSet;
	
	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CartList", joinColumns = @JoinColumn(name = "cartIdx", referencedColumnName = "idx"), inverseJoinColumns = @JoinColumn(name = "pidx", referencedColumnName = "idx"))
	private Collection<Product> cartList;
	
	public enum StatusSet {
		DELETE(0), NORMAL(1);

		private int setting;

		private StatusSet(int setting) {
			this.setting = setting;
		}

		public int getSetting() {
			return setting;
		}
	}
	
	public Cart() {
	}

	public Cart(long idx, StatusSet statusSet, Timestamp ts, Collection<Product> cartList) {
		this.idx = idx;
		this.statusSet = statusSet;
		this.ts = ts;
		this.cartList = cartList;
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	public StatusSet getStatusSet() {
		return statusSet;
	}

	public void setStatusSet(StatusSet statusSet) {
		this.statusSet = statusSet;
	}

	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

	public Collection<Product> getCartList() {
		return cartList;
	}

	public void setCartList(Collection<Product> cartList) {
		this.cartList = cartList;
	}
}
