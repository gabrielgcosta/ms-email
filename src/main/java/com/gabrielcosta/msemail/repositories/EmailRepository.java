package com.gabrielcosta.msemail.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielcosta.msemail.entities.EmailEntity;

public interface EmailRepository extends JpaRepository<EmailEntity, UUID> {
    
}
