package com.datasaver.api.controllers.forms;

public class UpdateFriendsForm {
	private String[] phoneNumbers;

	public UpdateFriendsForm() {
	}

	public UpdateFriendsForm(String[] phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public String[] getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(String[] phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
}