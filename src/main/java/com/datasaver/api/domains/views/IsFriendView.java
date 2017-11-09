package com.datasaver.api.domains.views;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IsFriendView {
	@Id
	private long uidx;
	private long fuidx;

	public IsFriendView() {
	}

	public IsFriendView(long uidx, long fuidx) {
		this.uidx = uidx;
		this.fuidx = fuidx;
	}

	public long getUidx() {
		return uidx;
	}

	public void setUidx(long uidx) {
		this.uidx = uidx;
	}

	public long getFuidx() {
		return fuidx;
	}

	public void setFuidx(long fuidx) {
		this.fuidx = fuidx;
	}
}