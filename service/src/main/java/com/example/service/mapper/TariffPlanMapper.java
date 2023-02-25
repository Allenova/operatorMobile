package com.example.service.mapper;

import com.example.dao.model.PhoneNumber;
import com.example.dao.model.TariffPlan;
import com.example.service.dto.PhoneNumberDto;
import com.example.service.dto.TariffPlanDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TariffPlanMapper {

    TariffPlanDto tariffPlanToTariffPlanDto(TariffPlan tariffPlan);
    TariffPlan tariffPlanDtoToTariffPlan(TariffPlanDto tariffPlanDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", source = "id", ignore = true)
    TariffPlan updateTariffPlanFromTariffPlanDto(TariffPlanDto tariffPlanDto, @MappingTarget TariffPlan tariffPlan);
}
