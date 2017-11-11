package com.datasaver.api.utils.aws;

import java.io.File;
import java.net.URL;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;

public class S3 {
	private AmazonS3 as3;

	public S3(String accessKeyId, String accessSecretKey, String endPoint) {
		as3 = new AmazonS3Client(new BasicAWSCredentials(accessKeyId, accessSecretKey));
		as3.setEndpoint(endPoint);
	}

	public void uploadFile(String bucketName, String name, File file) {
		as3.putObject(bucketName, name, file);
	}

	public void deleteFile(String bucketName, String name) {
		as3.deleteObject(bucketName, name);
	}

	public URL getFileUrl(String bucketName, String name) {
		return as3.generatePresignedUrl(new GeneratePresignedUrlRequest(bucketName, name));
	}
}