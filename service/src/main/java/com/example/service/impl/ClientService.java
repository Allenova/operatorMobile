package com.example.service.impl;

import com.example.dao.repository.AbstractClientRepository;
import com.example.service.AbstractClientService;
import com.example.service.dto.ClientDto;
import com.example.service.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClientService implements AbstractClientService {


    private final AbstractClientRepository abstractClientRepository;
    private final ClientMapper clientMapper;
    @Override
    public ClientDto getClientById(Long id) {
        return clientMapper.clientToClientDto(abstractClientRepository.getReferenceById(id)) ;
    }

    @Override
    public ClientDto findClientBySurName(String surName) {
        return clientMapper.clientToClientDto(abstractClientRepository.findBySurName(surName));
    }

    @Override
    public List<ClientDto> getAllClients() {
        return abstractClientRepository.findAll().stream().map(clientMapper::clientToClientDto).collect(Collectors.toList());
    }

    @Override
    public ClientDto saveClient(ClientDto clientDto) {
        return clientMapper.clientToClientDto(abstractClientRepository.save(clientMapper.clientDtoToClient(clientDto)));
    }

    @Override
    public void deleteClient(Long id) {
         abstractClientRepository.deleteById(id);
    }

    @Override
    public Integer numberOfClients() {
        return abstractClientRepository.findAll().size();
    }
}
