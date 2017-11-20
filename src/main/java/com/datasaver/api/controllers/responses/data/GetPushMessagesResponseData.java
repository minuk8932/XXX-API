package com.datasaver.api.controllers.responses.data;

public class GetPushMessagesResponseData {
	private GetPushMessageResponseData[] getPushMessageResponseDatas;
	private int unreadCounts;

	public GetPushMessagesResponseData() {
	}

	public GetPushMessagesResponseData(GetPushMessageResponseData[] getPushMessageResponseDatas, int unreadCounts) {
		this.getPushMessageResponseDatas = getPushMessageResponseDatas;
		this.unreadCounts = unreadCounts;
	}

	public GetPushMessageResponseData[] getGetPushMessageResponseDatas() {
		return getPushMessageResponseDatas;
	}

	public void setGetPushMessageResponseDatas(GetPushMessageResponseData[] getPushMessageResponseDatas) {
		this.getPushMessageResponseDatas = getPushMessageResponseDatas;
	}

	public int getUnreadCounts() {
		return unreadCounts;
	}

	public void setUnreadCounts(int unreadCounts) {
		this.unreadCounts = unreadCounts;
	}
}