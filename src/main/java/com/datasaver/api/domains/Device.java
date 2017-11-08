package com.datasaver.api.domains;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Device {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;

	@Column(name = "type")
	private Type type;

	@Column(name = "token")
	private String token;

	@Column(name = "uuid")
	private String uuid;

	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;

	@OneToOne
	@JoinColumn(name = "uidx")
	private User user;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "device")
	private Collection<PushQueue> pushQueues;

	public enum Type {
		ANDROID(0), IOS(1);

		private int code;

		private Type(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}
	}

	public Device() {
	}

	public Device(long idx, Type type, String token, String uuid, Timestamp ts, User user,
			Collection<PushQueue> pushQueues) {
		this.idx = idx;
		this.type = type;
		this.token = token;
		this.uuid = uuid;
		this.ts = ts;
		this.user = user;
		this.pushQueues = pushQueues;
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<PushQueue> getPushQueues() {
		return pushQueues;
	}

	public void setPushQueues(Collection<PushQueue> pushQueues) {
		this.pushQueues = pushQueues;
	}
}