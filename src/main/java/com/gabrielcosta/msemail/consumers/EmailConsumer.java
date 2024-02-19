package com.gabrielcosta.msemail.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.gabrielcosta.msemail.dto.EmailDTO;
import com.gabrielcosta.msemail.entities.EmailEntity;
import com.gabrielcosta.msemail.services.EmailService;

@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDTO emailDTO){
        EmailEntity emailEntity = new EmailEntity();
        BeanUtils.copyProperties(emailDTO, emailEntity);
        emailService.sendEmail(emailEntity);
        System.out.println("Email status: " + emailEntity.getStatusEmail().toString());
    }
    
}
