package com.example.service.impl;

import com.example.dao.model.Contract;
import com.example.dao.repository.AbstractClientRepository;
import com.example.dao.repository.AbstractContractRepository;
import com.example.dao.repository.AbstractTariffPlanRepository;
import com.example.service.AbstractContractService;
import com.example.service.dto.ContractDto;
import com.example.service.mapper.ClientMapper;
import com.example.service.mapper.ContractMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

@RequiredArgsConstructor
@Service
public class ContractService implements AbstractContractService {
    private final AbstractContractRepository abstractContractRepository;
    private final ContractMapper contractMapper;

    private final AbstractTariffPlanRepository abstractTariffPlanRepository;

    @Override
    public ContractDto save(ContractDto contractDto) {
        return contractMapper.contractToContractDto(abstractContractRepository.save(contractMapper.contractDtoToContract(contractDto)));
    }

    @Override
    public void deleteContract(Long id) {
        abstractContractRepository.deleteById(id);
    }

    @Override
    public List<ContractDto> getAllContract() {
        return abstractContractRepository.findAll().stream().map(contractMapper::contractToContractDto).collect(Collectors.toList());
    }

    @Override
    public ContractDto updateContract(Long id, ContractDto contractDto) {
        abstractContractRepository.updateTariffPlanById(contractMapper.contractDtoToContract(contractDto).getTariffPlan(), id);
        return contractMapper.contractToContractDto(abstractContractRepository.getReferenceById(id));
    }
}
