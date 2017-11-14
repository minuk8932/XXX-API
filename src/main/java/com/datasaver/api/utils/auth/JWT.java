package com.datasaver.api.utils.auth;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;

import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWT {
	private static final Logger LOG = Logger.getLogger(JWT.class.getSimpleName());

	private static final String ISSUER = "DataSaver";
	private static final String SECRET = "DataSaver-JWT!";

	public static String create(final long uidx) {
		try {
			JWTCreator.Builder b = com.auth0.jwt.JWT.create();
			b.withIssuer(ISSUER);
			b.withClaim("uidx", uidx);

			return b.sign(Algorithm.HMAC256(SECRET));
		} catch (UnsupportedEncodingException uee) {
			LOG.error(uee.getMessage());
		} catch (JWTCreationException jce) {
			LOG.error(jce.getMessage());
		}

		return null;
	}

	public static Token decode(final String token) {
		try {
			JWTVerifier v = com.auth0.jwt.JWT.require(Algorithm.HMAC256(SECRET)).withIssuer(ISSUER).build();
			DecodedJWT djwt = v.verify(token);

			return new Token(djwt.getClaim("uidx").asLong().longValue());
		} catch (UnsupportedEncodingException uee) {
			LOG.error(uee.getMessage());
		} catch (JWTVerificationException jve) {
			LOG.error(jve.getMessage());
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

		return null;
	}

	public static class Token {
		private long uidx;

		public Token() {
			// Not to use.
		}

		public Token(final long uidx) {
			this.uidx = uidx;
		}

		public long getUidx() {
			return uidx;
		}
	}
}