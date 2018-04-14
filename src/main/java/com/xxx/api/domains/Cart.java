package com.xxx.api.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;
	
	@Column(name = "status_set")
	private StatusSet statusSet;
	
	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;
	
	@ManyToOne
	@JoinColumn(name = "member_idx")
	@JsonIgnore
	private Member midx;
	
	public enum StatusSet {
		DELETE(0), SAVE(1);

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

	public Cart(long idx, StatusSet statusSet, Timestamp ts, Member midx) {
		this.idx = idx;
		this.statusSet = statusSet;
		this.ts = ts;
		this.midx = midx;
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

	public Member getMidx() {
		return midx;
	}

	public void setMidx(Member midx) {
		this.midx = midx;
	}
}
