package com.xxx.api.utils.password;

import java.util.Random;

/**
 * 
 * @author minchoba
 *	
 * PasswordGenerator class : 비밀번호 무작위 생성 클래스
 * -------------------------------------------
 * Random 객체를 통해 비밀번호를 생성하는 create() 
 * 메소드를 정의함
 * -------------------------------------------
 */
public class PasswordGenerator {
	private static final int LENGTH = 10;				// 생성될 비밀번호의 길이
	private static final int NUMBER_TYPE = 0;
	private static final int LOWER_ALPHABET_TYPE = 1;
	private static final int UPPER_ALPHABET_TYPE = 2;
	
	public static String create() {
		StringBuilder sb = new StringBuilder();
		Random rand = new Random();							// Random 객체 선언
		
		for(int i = 0; i < LENGTH; i++) {					// 10자리 비밀번호 생성 반복문
			switch(rand.nextInt(3)){							// 0 ~ 2 사이의 숫자를 무작위로 가져와서 조건문 시행
			case NUMBER_TYPE:								// 0이면, 숫자 0 ~ 9사이의 숫자를 무작위로 하나 버퍼에 담음
				sb.append(rand.nextInt(10));
				break;
				
			case LOWER_ALPHABET_TYPE :						// 1이면, 소문자 알파벳(ASCII code 97~122, a~z) 중 무작위로 하나를 버퍼에 담음
				sb.append((char) (rand.nextInt(26) + 97));
				break;
				
			case UPPER_ALPHABET_TYPE :						// 2이면, 대문자 알파벳(ASCII code 65~90, A~Z) 중 무작위로 하나를 버퍼에 담음
				sb.append((char) (rand.nextInt(26) + 65));
				break;
			}
		}
		
		return sb.toString();			// 버퍼에 담긴 10자리를 문자열로 반환
	}
}
