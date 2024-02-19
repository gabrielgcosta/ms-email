package com.gabrielcosta.msemail.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielcosta.msemail.dto.EmailDTO;
import com.gabrielcosta.msemail.entities.EmailEntity;
import com.gabrielcosta.msemail.services.EmailService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("send")
    public ResponseEntity<EmailEntity> postMethodName(@RequestBody @Valid EmailDTO emailDto) {

        EmailEntity emailEntity = new EmailEntity();

        // convert emailDto to emailEntity
        BeanUtils.copyProperties(emailDto, emailEntity);
        emailService.sendEmail(emailEntity);        
        
        return new ResponseEntity<>(emailEntity, HttpStatus.CREATED);
    }
    
    
}
