package com.xxx.api.utils.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Mail {
	private static final String FROM_NO_REPLY = "no_reply@xxx.com";				// 일방적 통보 메일 보낼 시 나타낼 주소 상수
	
	@Autowired
	public JavaMailSender jms;
	
	public boolean send(String subject, String text, String from, String to) {	// 응답 가능한 메일을 위한 전송 생성자
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom(from);
		smm.setTo(to);
		smm.setSubject(subject);
		smm.setText(text);
		
		try {							// 잘 보내졌으면 참 반환
			jms.send(smm);
			
			return true;
		}
		catch (MailException me) {		// 예외 발생시 거짓 반환
			return false;
		}
	}
	
	public boolean sendFromNoReply(String subject, String text, String to) {		// 일방적 통보 메일을 위한 생성자
		return send(subject, text, FROM_NO_REPLY, to);
	}
}
