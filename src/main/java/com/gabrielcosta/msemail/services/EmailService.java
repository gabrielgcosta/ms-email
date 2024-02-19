package com.gabrielcosta.msemail.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.gabrielcosta.msemail.entities.EmailEntity;
import com.gabrielcosta.msemail.enums.StatusEmail;
import com.gabrielcosta.msemail.repositories.EmailRepository;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    JavaMailSender emailSender;

    @SuppressWarnings("finally")
    public EmailEntity sendEmail(EmailEntity emailEntity) {
        emailEntity.setSentDateEmail(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailEntity.getEmailFrom());
            message.setTo(emailEntity.getEmailTo());
            message.setSubject(emailEntity.getSubject());
            message.setText(emailEntity.getText());
            emailSender.send(message);
            
            emailEntity.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            emailEntity.setStatusEmail(StatusEmail.ERROR);
        } finally{
            return emailRepository.save(emailEntity);
        }
        
    }
    
}
