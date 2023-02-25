package com.example.service;

import com.example.service.dto.PassportDto;

import java.util.List;

public interface AbstractPassportService {

    PassportDto save(PassportDto passportDto);
    List<PassportDto> getAllPassport();

}
