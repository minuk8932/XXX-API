package com.xxx.api.utils.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.xxx.api.domains.Member;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {
	Member.Type[] allowMemberTypes() default {
		Member.Type.NORMAL
	};
}
