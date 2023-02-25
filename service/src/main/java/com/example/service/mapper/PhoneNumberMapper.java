package com.example.service.mapper;

import com.example.dao.model.Contract;
import com.example.dao.model.PhoneNumber;
import com.example.service.dto.ContractDto;
import com.example.service.dto.PhoneNumberDto;
import org.mapstruct.*;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PhoneNumberMapper {


    PhoneNumberDto phoneNumberToPhoneNumberDto(PhoneNumber phoneNumber);
    PhoneNumber phoneNumberDtoToPhoneNumber(PhoneNumberDto phoneNumberDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", source = "id", ignore = true)
    PhoneNumber updatePhoneNumberFromPhoneNumberDto(PhoneNumberDto phoneNumberDto, @MappingTarget PhoneNumber phoneNumber);
}
