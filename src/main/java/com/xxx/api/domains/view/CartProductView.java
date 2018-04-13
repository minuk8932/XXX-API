package com.xxx.api.domains.view;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CartProductView {
	@Id
	private long cidx;
	private long pidx;
	
	public CartProductView() {
	}

	public CartProductView(long cidx, long pidx) {
		this.cidx = cidx;
		this.pidx = pidx;
	}

	public long getCidx() {
		return cidx;
	}

	public void setCidx(long cidx) {
		this.cidx = cidx;
	}

	public long getPidx() {
		return pidx;
	}

	public void setPidx(long pidx) {
		this.pidx = pidx;
	}
}
