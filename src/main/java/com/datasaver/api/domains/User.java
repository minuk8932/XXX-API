package com.datasaver.api.domains;

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
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private long idx;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "name")
	private String name;

	@Column(name = "phoneNumber", unique = true)
	private String phoneNumber;

	@Column(name = "profileImg")
	private String profileImg;

	@Column(name = "ts", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp ts;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Friend", joinColumns = @JoinColumn(name = "uidx", referencedColumnName = "idx"), inverseJoinColumns = @JoinColumn(name = "fuidx", referencedColumnName = "idx"))
	private Collection<User> friends;

	public User() {
	}

	public User(long idx, String email, String password, String name, String phoneNumber, String profileImg,
			Timestamp ts, Collection<User> friends) {
		this.idx = idx;
		this.email = email;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.profileImg = profileImg;
		this.ts = ts;
		this.friends = friends;
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

	public Collection<User> getFriends() {
		return friends;
	}

	public void setFriends(Collection<User> friends) {
		this.friends = friends;
	}
}