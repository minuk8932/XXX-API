package com.datasaver.api.utils.auth;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.datasaver.api.controllers.responses.DefaultResponse;
import com.datasaver.api.controllers.responses.DefaultResponse.Status;
import com.datasaver.api.domains.User;
import com.datasaver.api.services.UserService;
import com.datasaver.api.utils.auth.JWT.Token;
import com.datasaver.api.utils.res.Strings;

@Component
@Aspect
public class AuthAspect {
	@Autowired
	private HttpServletRequest hsr;

	@Autowired
	private UserService us;

	@Around("@annotation(com.datasaver.api.utils.auth.Auth) && @annotation(authAnotation)")
	public Object around(ProceedingJoinPoint pjp, Auth authAnotation) throws Throwable {
		String jwt = hsr.getHeader("Authorization");

		if (jwt == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.MUST_NEED_JWT);
			return new ResponseEntity<>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		Token t = JWT.decode(jwt);

		if (t == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.FAIL_TO_DECODE_TOKEN);
			return new ResponseEntity<>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}

		User u = us.findByIdx(t.getUidx());

		if (u == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_USER);
			return new ResponseEntity<>(dr, HttpStatus.UNAUTHORIZED);
		}

		User.Type userType = u.getType();

		if (userType != User.Type.ADMINISTRATOR) {
			boolean isAllowedUser = false;

			for (User.Type allowUserType : authAnotation.allowUserTypes()) {
				if (userType == allowUserType) {
					isAllowedUser = true;
					break;
				}
			}

			if (!isAllowedUser) {
				DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.NEED_APPROPRIATE_AUTHORIZATION);
				return new ResponseEntity<>(dr, HttpStatus.UNAUTHORIZED);
			}
		}

		Object[] params = pjp.getArgs();

		for (int i = 0; i < params.length; i++) {
			if (params[i] instanceof User) {
				params[i] = u;

				break;
			}
		}

		return pjp.proceed(params);
	}
}