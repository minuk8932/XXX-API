package com.xxx.api.utils.log;

import java.sql.Timestamp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xxx.api.controllers.responses.DefaultResponse;

/**
 * 
 * @author minchoba
 * LogAspect class : 로그를 띄워주는 Aspect class
 * ------------------------------------------------------------------------
 * *join point : 공통 관심사를 적용 할 수 있는 대상, Spring AOP에선 각 객체의 Method
 * 				-> 작성된 Advice가 작동되는 위치를 의미
 * serializeNulls : Serialize시 변수가 null이면 json의 해당 항목이 빠지므로, null까지
 * 					포함시키는 Method
 * ResponseEntity : HTTP의 전반적인 응답을 나타낸다.status code, body, header 등
 * 					어느것이든 제어 가능.
 * 				-> 즉 개발자가 직접 데이터 결과와 HTTP 상태 코드를 제어할 수 있는 클래스
 * ------------------------------------------------------------------------
 */

@Component	// 개발자가 직접 컨트롤 가능한 class
@Aspect		// Aspect Class 생성 어노테이션
public class LogAspect {
	private static final String END_LINE = "\n";
	
	// 대상 객체의 메서드 실행 전, 후 또는 예외 발생 시점에 공통 기능을 실행
	@Around("@annotation(com.xxx.api.utils.log.ControllerLog)")		// Around 선언시 반드시 첫 인자로 ProceedJoinPoint
																	// ProceedingJoinPoint 객체를 통해 핵심 비즈니스 로직을 가지고 있는 객체를 가져옴
	public ResponseEntity<DefaultResponse> controllerLogAround(ProceedingJoinPoint pjp) throws Throwable{
		long startCTM = System.currentTimeMillis();				// 시작된 현재 시간을 startCTM에 저장
		
		@SuppressWarnings("unchecked")
		// 가져온 핵심 비즈니스 로직을 proceed()를 통해 호출
		ResponseEntity<DefaultResponse> re = (ResponseEntity<DefaultResponse>) pjp.proceed();

		long endCTM = System.currentTimeMillis();				// 완료된 현재 시간을 endCTM에 저장
		
		Signature s = pjp.getSignature();			// 해당 클래스의 경로에 일치하는 join point*를 가져옴
		Class<?> c = s.getDeclaringType();			// 해당 조인 포인트의 정규 명칭을 가져옴
		Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();	// Gson을 null을 포함해 직렬화 하여 생성
		
		StringBuilder sb = new StringBuilder();
		sb.append("[Current time]: ").append(new Timestamp(System.currentTimeMillis())).append(END_LINE);
		sb.append("[Controller Name]: ").append(getClassName(c)).append(END_LINE);
		sb.append("[API Name]: ").append(s.getName()).append(END_LINE).append(END_LINE);
		sb.append("[Request Objects]").append(END_LINE);
		sb.append(gson.toJson(pjp.getArgs())).append(END_LINE);
		sb.append("[Response Objects]: ").append(re.getStatusCode()).append(END_LINE);
		sb.append(gson.toJson(re.getBody())).append(END_LINE);
		sb.append("[Total Runtime]: ").append(endCTM - startCTM).append("ms").append(END_LINE);	// StringBuilder를 통해 각 항목들을 버퍼에 담고
		
		System.out.println(sb.toString());		// 문자열로 한번에 출력
		
		return re;			// ResponseEntity 객체 반환
	}
	
	private static String getClassName(Class<?> c) {		// class 이름을 받아오는 메소드
		if (c.isAnonymousClass())
			return getClassName(c.getEnclosingClass());

		return c.getName();
	}
}
