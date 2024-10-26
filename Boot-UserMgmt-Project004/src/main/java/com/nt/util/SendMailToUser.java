package com.nt.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;



@Component
public class SendMailToUser {
	@Autowired
	private JavaMailSender sender;
    public Boolean sendMail(String mail,String mailBody,String subject) throws Exception {
    	Boolean mailSenStatus=false;
    	try {
    	
    	   MimeMessage msg=sender.createMimeMessage();
    	   //helper class
    	   MimeMessageHelper helper=new MimeMessageHelper(msg,true);
    	   helper.setTo(mail);
    	   helper.setSentDate(new Date());
    	   helper.setSubject(subject);
    	   helper.setText(mailBody,true);
    	   sender.send(msg);
    	   mailSenStatus=true;
    	}catch(Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    	
    	return mailSenStatus;
    	   
    }
}
