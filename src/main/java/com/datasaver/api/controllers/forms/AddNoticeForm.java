package com.datasaver.api.controllers.forms;

public class AddNoticeForm {
	private String title;
	private String contents;
	
	public AddNoticeForm() {
	}
	
	public AddNoticeForm(String title, String contents) {
		this.title = title;
		this.contents = contents;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
}
