package com.example.service.mapper;

import com.example.dao.model.Contract;
import com.example.service.dto.ContractDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ContractMapper {

    Contract contractDtoToContract(ContractDto contractDto);
    ContractDto contractToContractDto(Contract contract);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", source = "id", ignore = true)
    Contract updateContractFromContractDto(ContractDto contractDto, @MappingTarget Contract contract);
}
