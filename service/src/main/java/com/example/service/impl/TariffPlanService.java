package com.example.service.impl;

import com.example.dao.model.TariffPlan;
import com.example.dao.repository.AbstractTariffPlanRepository;
import com.example.service.AbstractTariffPlanService;
import com.example.service.dto.TariffPlanDto;
import com.example.service.mapper.TariffPlanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class TariffPlanService implements AbstractTariffPlanService {

    private final AbstractTariffPlanRepository abstractTariffPlanRepository;
    private final TariffPlanMapper tariffPlanMapper;

    @Override
    public TariffPlanDto saveTariff(TariffPlanDto tariffPlanDto) {
        return tariffPlanMapper.tariffPlanToTariffPlanDto(abstractTariffPlanRepository
                .save(tariffPlanMapper.tariffPlanDtoToTariffPlan(tariffPlanDto)));
    }

    @Override
    public void deleteTariff(Long id) {
        abstractTariffPlanRepository.deleteById(id);
    }

    @Override
    public TariffPlanDto getTariffPlanById(Long id) {
        return tariffPlanMapper.tariffPlanToTariffPlanDto(abstractTariffPlanRepository.getReferenceById(id));
    }

    @Override
    public List<TariffPlanDto> getAll() {
        return abstractTariffPlanRepository.findAll().stream().map(tariffPlanMapper::tariffPlanToTariffPlanDto).collect(Collectors.toList());
    }

    @Override
    public List<TariffPlanDto> findByPriceAndFreeMinutes(Long minFreeMinutes, Long maxFreeMinutes, Double minPrice, Double maxPrice) {
        List<TariffPlanDto> tariffPlanDtoList = abstractTariffPlanRepository.findAll().stream().map(tariffPlanMapper::tariffPlanToTariffPlanDto).collect(Collectors.toList());
        List<TariffPlanDto> result = tariffPlanDtoList.stream().filter(tariffPlanDto -> {
            if (tariffPlanDto.getFreeMinute() >= minFreeMinutes && tariffPlanDto.getFreeMinute() <= maxFreeMinutes
                    && tariffPlanDto.getPrice() >= minPrice && tariffPlanDto.getPrice() <= maxPrice) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<TariffPlanDto> findByIsArchive(Boolean isArchive) {
        List<TariffPlanDto> tariffPlanDtoList =abstractTariffPlanRepository.findAll().stream().map(tariffPlanMapper::tariffPlanToTariffPlanDto).collect(Collectors.toList()); ;
        List<TariffPlanDto> result = tariffPlanDtoList.stream().filter(tariffPlanDto -> {
            if (tariffPlanDto.getIsArchive() == isArchive) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());
        return result;
    }

    @Override
    public TariffPlanDto updateTariffPlan(Long id, TariffPlanDto tariffPlanDto) {
        abstractTariffPlanRepository.updateFreeMinuteAndPriceAndIsArchiveById(tariffPlanDto.getFreeMinute(), tariffPlanDto.getPrice(), tariffPlanDto.getIsArchive(), id);
        return tariffPlanMapper.tariffPlanToTariffPlanDto(abstractTariffPlanRepository.getReferenceById(id));
    }

}
