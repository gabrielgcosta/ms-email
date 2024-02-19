package com.gabrielcosta.msemail.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.gabrielcosta.msemail.enums.StatusEmail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "mail")
public class EmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sentDateEmail;
    private StatusEmail statusEmail;
    
}
