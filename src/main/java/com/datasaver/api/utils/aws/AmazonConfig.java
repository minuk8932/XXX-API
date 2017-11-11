package com.datasaver.api.utils.aws;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "amazon")
public class AmazonConfig {
	private String accessKeyId;
	private String accessSecretKey;
	private String endPoint;
	private String userProfileImgBucketName;

	public String getAccessKeyId() {
		return accessKeyId;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	public String getAccessSecretKey() {
		return accessSecretKey;
	}

	public void setAccessSecretKey(String accessSecretKey) {
		this.accessSecretKey = accessSecretKey;
	}

	public String getUserProfileImgBucketName() {
		return userProfileImgBucketName;
	}

	public void setUserProfileImgBucketName(String userProfileImgBucketName) {
		this.userProfileImgBucketName = userProfileImgBucketName;
	}
}