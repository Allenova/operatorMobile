package com.example.dao.repository;

import com.example.dao.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbstractClientRepository extends JpaRepository<Client,Long> {
    Client findBySurName(String surName);
}
