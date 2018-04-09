package com.xxx.api.utils.password;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.xxx.api.utils.res.Strings;

/**
 * 
 * @author minchoba
 *
 * Encryptor class : 암호화 알고리즘을 통한 암호생성기
 * -------------------------------------------
 * 비밀번호 보안의 대표적인 모듈인 SHA-256을 통해 사용자의
 * 비밀번호를 입력으로 받아 해당 값을 암호화 해주는 클래스
 * 
 * -> 단방향 변환
 * -------------------------------------------
 */
public class Encryptor {
	public static final String ALGORITHM = "SHA-256";					// 인코딩 암호화 모듈 문자열
	
	public static String process(String password) {					// 암호화 프로세스 메소드
		try {
			MessageDigest md = MessageDigest.getInstance(ALGORITHM);	// getInstance 메소드로 인자를 생성하여, 해당 모듈을 담아줌
			md.update(password.getBytes());							// md내의 비밀번호 값을 바이트코드로 변환(데이터 해싱)
			
			StringBuilder sb = new StringBuilder();
			
			for(byte b : md.digest()) {
				sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1)); // 비밀번호를 문자열로 바꾼 후 식에 따라 변환
			}
			
			return sb.toString();									// 버퍼내의 값들을 한번에 문자열로 변환해 반환
		}
		catch(NoSuchAlgorithmException nsae) {
			return Strings.NO_CORRESPONDING_ALGORITHM_WAS_FOUND;		// 해당 알고리즘이 존재하지 않음을 문자열 반환으로 알려줌
		}
	}
}
