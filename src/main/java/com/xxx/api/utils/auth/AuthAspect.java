package com.xxx.api.utils.auth;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.xxx.api.controllers.responses.DefaultResponse;
import com.xxx.api.controllers.responses.DefaultResponse.Status;
import com.xxx.api.domains.Member;
import com.xxx.api.services.MemberService;
import com.xxx.api.utils.auth.JsonWebToken.Token;
import com.xxx.api.utils.res.Strings;

/**
 * 
 * @author minchoba
 * 
 * AuthAspect class : AOP(관점 지향 프로그래밍)를 통한 권한 부여
 * ------------------------------------------
 * Around annotation : Around Advice 구현
 * 대상 객체의 메서드 실행 전, 후 또는 
 * 예외 발생 시점에 공통 기능을 실행
 * 
 * - Around Advice를 구현한 메서드는
 * 	 org.aspectj.lang.ProceedingJoinPoint를 
 * 	 반드시 첫 번째 파리미터로 지정해야 함
 * 	 -> 그렇지 않을 경우 예외 발생 
 * ------------------------------------------
 *
 */

@Component				// 개발자가 직접 컨트롤 가능한 class
@Aspect
public class AuthAspect {
	@Autowired
	private HttpServletRequest hsr;	// 값을 받아오는 객체 아이디, 비밀번호 등의 데이터를 컨트롤러로 보냈을때 해당 객체에 담김
	
	@Autowired
	private MemberService ms;
	
	@Around("@annotation(com.xxx.api.utils.auth.Auth) && @annotation(authAnotation)")
	public Object around(ProceedingJoinPoint pjp, Auth authAnotation) throws Throwable {	// Around-Advice 구현 메서드: ProceedingJoinPoint 첫 파라미터 지정
		String jwt = hsr.getHeader("Authorization"); 									// 클라이언트 플랫폼 정보 및 브라우저 정보를 문자열에 담아줌
		
		if(jwt == null) {																// 만약 null이면, DefaultResponse 클래스를 통해 상태와 메시지을 담고
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.MUST_NEED_JWT);	// 해당 객체와, HttpStatus를 함께 반환
			return new ResponseEntity<>(dr, HttpStatus.SERVICE_UNAVAILABLE);
		}
		
		Token t = JsonWebToken.decode(jwt);			// 복호화된 토큰을 반환해 토큰 변수에 저장
		
		if(t == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.FAIL_TO_DECODE_TOKEN);
			return new ResponseEntity<>(dr, HttpStatus.SERVICE_UNAVAILABLE);		// 토큰이 null일 경우 위의 jwt 조건문과 같이 처리해줌
		}
		
		Member m = ms.fingByIdx(t.getMidx());		// 멤버 클래스의 idx를 받아오고
		
		if(m == null) {
			DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.CAN_NOT_FOUND_MEMBER);
			return new ResponseEntity<>(dr, HttpStatus.UNAUTHORIZED);				// idx가 없을 경우 위의 두 경우와 같이 에러 메시지 출력
		}
		
		Member.Type memberType = m.getType();		// 멤버 클래스의 타입을 받아오고
		
		if(memberType != Member.Type.ADMINISTRATOR) {	// 해당 클래스의 타입이 ADMINISTRATOR가 아닌경우 : 즉 일반 멤버일 경우
			boolean isAllowedMember = false;
			
			for(Member.Type allowMemberType : authAnotation.allowMemberTypes()) {
				if(memberType == allowMemberType) {	// 반복문을 통해 권한을 허가 해야 할 멤버라면 허가된 멤버에 참값 할당 후 반복문 종료
					isAllowedMember = true;
					break;
				}
			}
			
			if(!isAllowedMember) {					// 허가되지 않은 멤버는
				DefaultResponse dr = new DefaultResponse(Status.FAIL, Strings.NEED_APPROPRIATE_AUTHORIZATION);
				return new ResponseEntity<>(dr, HttpStatus.UNAUTHORIZED);		// 위의 경우들과 마찬가지로, 에러 머시지 출력
			}
		}
		
		Object[] params = pjp.getArgs();			// 파라미터를 Proceeding Join Point에서 받아와 배열로 선언
		
		for(int i = 0; i < params.length; i++) {
			if(params[i] instanceof Member) {	// 인스턴스화 된 파라미터들이 Member에 해당한다면, 
				params[i] = m;					// 해당 배열에 Member클래스 idx를 담아주고
				
				break;							// 반복문 종료
			}
		}
		
		return pjp.proceed(params);				// 해당 idx를 타겟 메소드에 반환
	}
	
}