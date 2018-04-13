package com.xxx.api.domains.view;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderProductView {
	@Id
	private long idx;
	private long pidx;
		
	public OrderProductView() {
	}

	public OrderProductView(long idx, long pidx) {
		this.idx = idx;
		this.pidx = pidx;
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	public long getPidx() {
		return pidx;
	}

	public void setPidx(long pidx) {
		this.pidx = pidx;
	}
}
