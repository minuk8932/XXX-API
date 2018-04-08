package com.xxx.api.utils.auth;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * 
 * 	@author minchoba
 *	
 *	JWT(Json Web Token) class
 *	------------------------------------------	
 *	현 프로젝트에선 HMAC256 알고리즘을 통해 암호화 하였음.
 *	------------------------------------------
 *
 */

public class JsonWebToken {
	private static final Logger LOG = Logger.getLogger(JWT.class.getSimpleName());	// 로그 기록을 띄워줄 상수
	
	private static final String ISSUER = "XXX";										// 발행인 문자열 상수
	private static final String SECRET = "XXX-JsonWebToken!";							// 확인 또는 인증 인스턴스에 사용할 암호 문자열
	
	// 문자열 토큰 생성(암호화)
	public static String create(final long midx) {
		try {
			JWTCreator.Builder jwtb = com.auth0.jwt.JWT.create();						// JWT 빌더 변수 선언
			jwtb.withIssuer(ISSUER);													// 발행인과, idx 매개변수를 해당 빌더 변수에 담아줌
			jwtb.withClaim("midx", midx);
			
			return jwtb.sign(Algorithm.HMAC256(SECRET));								// jwtb 변수에 담긴 데이터 정보들을 암호화 하여 반환
		}
		catch (UnsupportedEncodingException uee){			// 인코딩, JWT 생성 예외 처리
			LOG.error(uee.getMessage());
		}
		catch (JWTCreationException jwtce) {
			LOG.error(jwtce.getMessage());
		}
		
		return null;
	}
	
	// 문자열 토큰 디코딩(복호화)
	public static Token decode(final String token){
		try {
			JWTVerifier jwtv = com.auth0.jwt.JWT.require(Algorithm.HMAC256(SECRET)).withIssuer(ISSUER).build();	
			DecodedJWT djwt = jwtv.verify(token);							// JWT를 검증한 후 복호화 클래스 변수에 담아줌
			
			return new Token(djwt.getClaim("midx").asLong().longValue());		// 복호화 된 idx를 토큰 객체아 담아서 반환
		}
		catch (UnsupportedEncodingException uee) {	// 인코딩, jwt 검증, 기본 예외 처리
			LOG.error(uee.getMessage());
		}
		catch (JWTVerificationException jwtve) {
			LOG.error(jwtve.getMessage());
		}
		catch (Exception e) {
			LOG.error(e.getMessage());
		}
		
		return null;
	}
	
	// 토큰 생성자 클래스
	public static class Token {
		private long midx;

		public Token() {
		}

		public Token(final long midx) {
			this.midx = midx;
		}

		public long getMidx() {
			return midx;
		}
	}
}
