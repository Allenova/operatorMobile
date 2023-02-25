package com.example.service.impl;

import com.example.dao.model.PhoneNumber;
import com.example.dao.repository.AbstractPhoneNumberRepository;
import com.example.service.AbstractPhoneNumberService;
import com.example.service.dto.PhoneNumberDto;
import com.example.service.mapper.PhoneNumberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

@RequiredArgsConstructor
@Service
public class PhoneNumberService implements AbstractPhoneNumberService {
    private final AbstractPhoneNumberRepository abstractPhoneNumberRepository;
    private final PhoneNumberMapper phoneNumberMapper;

    @Override
    public PhoneNumberDto save(PhoneNumberDto phoneNumberDto) {
        return phoneNumberMapper.phoneNumberToPhoneNumberDto(abstractPhoneNumberRepository.save(phoneNumberMapper.phoneNumberDtoToPhoneNumber(phoneNumberDto)));
    }

    @Override
    public void delete(Long id) {
        abstractPhoneNumberRepository.deleteById(id);
    }

    @Override
    public PhoneNumberDto findById(Long id) {
        return phoneNumberMapper.phoneNumberToPhoneNumberDto(abstractPhoneNumberRepository.getReferenceById(id));
    }

    @Override
    public List<PhoneNumberDto> getAll() {
        return abstractPhoneNumberRepository.findAll().stream().map(phoneNumberMapper::phoneNumberToPhoneNumberDto).collect(Collectors.toList());
    }

    @Override
    public List<PhoneNumberDto> findAllByActive(Boolean active) {
        List<PhoneNumberDto> numberDto = getAll();
        List<PhoneNumberDto> result = numberDto.stream().filter(phoneNumberDto -> {
            if (phoneNumberDto.getActive() == active) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());
        return result;
    }



    public PhoneNumberDto updatePhoneNumber(PhoneNumberDto phoneNumberDto,Long id){
      abstractPhoneNumberRepository.updateActiveById(phoneNumberDto.getActive(),id);
      return phoneNumberMapper.phoneNumberToPhoneNumberDto(abstractPhoneNumberRepository.getReferenceById(id));
    }
}
