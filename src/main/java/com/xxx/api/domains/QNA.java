package com.xxx.api.domains;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class QNA {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;
	
	@Column(name = "question", columnDefinition = "TEXT")
	private String question;

	@Column(name = "answer", columnDefinition = "TEXT")
	private String answer;

	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;
	
	@ManyToOne
	@Column(name = "mid")
	@JsonIgnore
	private Member mid;
	
	public QNA() {
	}

	public QNA(long idx, String question, String answer, Timestamp ts, Member mid) {
		this.idx = idx;
		this.question = question;
		this.answer = answer;
		this.ts = ts;
		this.mid = mid;
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

	public Member getMid() {
		return mid;
	}

	public void setMid(Member mid) {
		this.mid = mid;
	}
}
