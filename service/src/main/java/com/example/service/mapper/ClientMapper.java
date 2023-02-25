package com.example.service.mapper;

import com.example.dao.model.Client;
import com.example.service.dto.ClientDto;
import org.mapstruct.*;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ClientMapper {

    ClientDto clientToClientDto(Client client);
    Client clientDtoToClient(ClientDto clientDto);
}
