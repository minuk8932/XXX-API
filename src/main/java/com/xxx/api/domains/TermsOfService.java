package com.xxx.api.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TermsOfService {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;
	
	@Column(name = "contents", columnDefinition = "TEXT")
	private String contents;
	
	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;
	
	public TermsOfService() {
	}

	public TermsOfService(long idx, String contents, Timestamp ts) {
		this.idx = idx;
		this.contents = contents;
		this.ts = ts;
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
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
