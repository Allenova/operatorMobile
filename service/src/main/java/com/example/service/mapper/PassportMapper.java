package com.example.service.mapper;

import com.example.dao.model.Passport;
import com.example.service.dto.PassportDto;
import org.mapstruct.*;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PassportMapper {

    PassportDto passportToPassportDto(Passport passport);
    Passport passportDtoToPassport(PassportDto passportDto);
}
