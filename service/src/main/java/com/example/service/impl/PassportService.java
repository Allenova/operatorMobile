package com.example.service.impl;

import com.example.dao.repository.AbstractPassportRepository;
import com.example.service.AbstractPassportService;
import com.example.service.dto.PassportDto;
import com.example.service.mapper.PassportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PassportService implements AbstractPassportService {

    private final AbstractPassportRepository abstractPassportRepository;
    private final PassportMapper passportMapper;

    public PassportDto save(PassportDto passportDto){
        return passportMapper.passportToPassportDto(abstractPassportRepository.save(passportMapper.passportDtoToPassport(passportDto)));
    }

    @Override
    public List<PassportDto> getAllPassport() {
        return abstractPassportRepository.findAll().stream().map(passportMapper::passportToPassportDto).collect(Collectors.toList());
    }

}
