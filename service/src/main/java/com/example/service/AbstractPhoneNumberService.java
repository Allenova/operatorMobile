package com.example.service;

import com.example.service.dto.PhoneNumberDto;

import java.util.List;

public interface AbstractPhoneNumberService {

    PhoneNumberDto save(PhoneNumberDto phoneNumberDto);
    void delete(Long id);
    PhoneNumberDto findById(Long id);
    List<PhoneNumberDto> getAll();

    List<PhoneNumberDto>findAllByActive(Boolean active);

    PhoneNumberDto updatePhoneNumber(PhoneNumberDto phoneNumberDto,Long id);
}
