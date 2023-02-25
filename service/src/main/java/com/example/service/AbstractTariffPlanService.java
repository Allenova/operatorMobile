package com.example.service;

import com.example.service.dto.TariffPlanDto;

import java.util.List;

public interface AbstractTariffPlanService {

    TariffPlanDto saveTariff(TariffPlanDto tariffPlanDto);

    void deleteTariff(Long id);

    TariffPlanDto getTariffPlanById(Long id);

    List<TariffPlanDto> getAll();

    List<TariffPlanDto> findByPriceAndFreeMinutes( Long minFreeMinutes,Long maxFreeMinutes,Double minPrice, Double maxPrice);

    List<TariffPlanDto> findByIsArchive(Boolean isArchive);

    TariffPlanDto updateTariffPlan(Long id, TariffPlanDto tariffPlanDto);

}
