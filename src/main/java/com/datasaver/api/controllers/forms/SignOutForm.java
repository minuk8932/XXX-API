package com.datasaver.api.controllers.forms;

public class SignOutForm {
	private String email;
	private String password;

	public SignOutForm() {
	}

	public SignOutForm(String email, String password) {
		this.email = email;
		this.password = password;
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
}
