package com.nus.invms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.nus.invms.domain.User;

@Service
public class NotificationService {
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender=javaMailSender;
	}

	public void sendNotification() throws MailException{
		
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo("wsysteam@gmail.com");
		mail.setFrom("1400941583a@gmail.com");
		mail.setSubject("Reminder");
		mail.setText("This product needs to reorder.");
		
		
		javaMailSender.send(mail);
	}
	
	
}
