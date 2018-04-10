package com.xxx.api.utils.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 	@author minchoba
 *	ControllerLog : 사용자 정의 어노테이션 생성 interface
 *
 */

@Target(ElementType.METHOD)				// Target은 Method에만 적용되도록 함
@Retention(RetentionPolicy.RUNTIME)		// JVM 실행시 감지
public @interface ControllerLog {
}
