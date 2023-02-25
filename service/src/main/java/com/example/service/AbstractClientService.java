package com.example.service;

import com.example.dao.model.Client;
import com.example.service.dto.ClientDto;

import java.util.List;

public interface AbstractClientService {
    ClientDto getClientById(Long id);

   ClientDto findClientBySurName(String surName);

    List<ClientDto> getAllClients();

    ClientDto saveClient(ClientDto clientDto);

    void deleteClient(Long id);

    Integer numberOfClients();
}
