//package com.nus.invms.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.MailException;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//public class NotificationService {
//private JavaMailSender javaMailSender;
//	
//	@Autowired
//	public NotificationService(JavaMailSender javaMailSender) {
//		this.javaMailSender=javaMailSender;
//	}
//
//	public void sendNotification(String msg) throws MailException{
//		
//		SimpleMailMessage mail=new SimpleMailMessage();
//		mail.setTo("wsysteam@gmail.com");
//		mail.setFrom("1400941583a@gmail.com");
//		mail.setSubject("Reminder");
//		mail.setText("Product Id: " + msg + " need to be replenish.");
//		
//		
//		javaMailSender.send(mail);
//	}
//}
