package com.example.controller;

import com.example.service.AbstractClientService;
import com.example.service.dto.ClientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("api/clients")
public class ClientController {

    private final AbstractClientService abstractClientService;

    @GetMapping("/getById")
   public ClientDto getClientById(@RequestParam Long id) {
        return abstractClientService.getClientById(id);
    }

    @GetMapping("/getBySurName")
    public ClientDto findClientBySurName(@RequestParam String surName) {
        return abstractClientService.findClientBySurName(surName);
    }

    @GetMapping("/getAll")
   public List<ClientDto> getAllClients() {
        return abstractClientService.getAllClients();
    }

    @PostMapping("/saveClient")
    public ClientDto saveClient(@RequestBody ClientDto clientDto) {
        return abstractClientService.saveClient(clientDto);
    }

    @DeleteMapping("/deleteClient")
   public void deleteClient(@RequestParam Long id) {
       abstractClientService.deleteClient(id);
    }

    @GetMapping("/getNumbsrsOfClients")
    public Integer numberOfClients() {
        return abstractClientService.numberOfClients();
    }
}
