package com.xxx.api.domains.view;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderProductView {
	@Id
	private long oidx;
	private long pidx;
		
	public OrderProductView() {
	}

	public OrderProductView(long oidx, long pidx) {
		this.oidx = oidx;
		this.pidx = pidx;
	}

	public long getIdx() {
		return oidx;
	}

	public void setIdx(long oidx) {
		this.oidx = oidx;
	}

	public long getPidx() {
		return pidx;
	}

	public void setPidx(long pidx) {
		this.pidx = pidx;
	}
}
