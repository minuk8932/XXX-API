package com.datasaver.api.utils.password;

import java.util.Random;

public class PasswordGenerator {
	private static final int LENGTH = 10;
	private static final int NUMBER_TYPE = 0;
	private static final int LOWER_ALPHABET_TYPE = 1;
	private static final int UPPER_ALPHABET_TYPE = 2;

	public static String create() {
		StringBuilder sb = new StringBuilder();
		Random r = new Random();

		for (int i = 0; i < LENGTH; i++) {
			switch (r.nextInt(3)) {
			case NUMBER_TYPE:
				sb.append(r.nextInt(10));
				break;

			case LOWER_ALPHABET_TYPE:
				sb.append((char) (r.nextInt(26) + 65));
				break;

			case UPPER_ALPHABET_TYPE:
				sb.append((char) (r.nextInt(26) + 97));
				break;
			}
		}

		return sb.toString();
	}
}