package com.example.service;

import com.example.service.dto.ContractDto;

import java.util.List;

public interface AbstractContractService {

    ContractDto save (ContractDto contractDto);
    void deleteContract(Long id);
    List<ContractDto> getAllContract();
    ContractDto updateContract(Long id,ContractDto contractDto);
}
