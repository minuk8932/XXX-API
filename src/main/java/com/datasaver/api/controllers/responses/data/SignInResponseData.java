package com.datasaver.api.controllers.responses.data;

public class SignInResponseData {
	private String token;

	public SignInResponseData() {
	}

	public SignInResponseData(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}