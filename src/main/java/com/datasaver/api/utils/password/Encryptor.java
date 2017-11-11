package com.datasaver.api.utils.password;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {
	private static final String ALGORITHM = "SHA-256";

	public static String process(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance(ALGORITHM);
			md.update(password.getBytes());

			StringBuffer sb = new StringBuffer();

			for (byte b : md.digest())
				sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));

			return sb.toString();
		} catch (NoSuchAlgorithmException nsae) {
			return null;
		}
	}
}