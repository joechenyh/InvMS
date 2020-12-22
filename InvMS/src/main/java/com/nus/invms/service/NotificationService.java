package com.nus.invms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender=javaMailSender;
	}

	public void sendNotification(String msg) throws MailException{
		
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo("keyint94@gmail.com");
		mail.setFrom("rahmatkhairi91@gmail.com");
		mail.setSubject("Reminder");
		mail.setText(msg);
		
		
		javaMailSender.send(mail);
	}
}
