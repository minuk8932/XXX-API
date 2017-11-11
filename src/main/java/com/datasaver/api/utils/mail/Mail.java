package com.datasaver.api.utils.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Mail {
	private static final String FROM_NO_REPLY = "no-reply@datasaver.com";

	@Autowired
	public JavaMailSender jms;

	public boolean send(String subject, String text, String from, String... to) {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom(from);
		smm.setTo(to);
		smm.setSubject(subject);
		smm.setText(text);

		try {
			jms.send(smm);

			return true;
		} catch (MailException me) {
			return false;
		}
	}

	public boolean sendFromNoRely(String subject, String text, String... to) {
		return send(subject, text, FROM_NO_REPLY, to);
	}
}