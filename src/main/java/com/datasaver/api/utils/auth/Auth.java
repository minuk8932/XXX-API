package com.datasaver.api.utils.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.datasaver.api.domains.User;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {
	User.Type[] allowUserTypes() default { User.Type.NORMAL };
}