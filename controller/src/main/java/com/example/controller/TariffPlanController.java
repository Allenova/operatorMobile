package com.example.controller;

import com.example.service.AbstractTariffPlanService;
import com.example.service.dto.TariffPlanDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/tariffPlans")
public class TariffPlanController {

    private final AbstractTariffPlanService abstractTariffPlanService;

    @PostMapping("/saveTariff")
    public TariffPlanDto saveTariff(@RequestBody TariffPlanDto tariffPlanDto) {
        return abstractTariffPlanService.saveTariff(tariffPlanDto);
    }

    @DeleteMapping("/deleteTariff")
    public void deleteTariff(@RequestParam Long id) {
        abstractTariffPlanService.deleteTariff(id);
    }

    @GetMapping("/getById")
    public TariffPlanDto getTariffPlanById(@RequestParam Long id) {
        return abstractTariffPlanService.getTariffPlanById(id);
    }

    @GetMapping("/getAll")
    public List<TariffPlanDto> getAll() {
        return abstractTariffPlanService.getAll();
    }

    @GetMapping("/getByFreeMinutesAndPrice")
    public List<TariffPlanDto> findByPriceAndFreeMinutes(@RequestParam Long minFreeMinutes, @RequestParam Long maxFreeMinutes,
                                                         @RequestParam Double minPrice, @RequestParam Double maxPrice) {
        return abstractTariffPlanService.findByPriceAndFreeMinutes(minFreeMinutes, maxFreeMinutes, minPrice, maxPrice);
    }

    @GetMapping("/getByIsArchive")
    public List<TariffPlanDto> findByIsArchive(Boolean isArchive) {
        return abstractTariffPlanService.findByIsArchive(isArchive);
    }

    @PatchMapping("/updateTariffPlan")
    public TariffPlanDto updateTariffPlan(Long id, TariffPlanDto tariffPlanDto){
       return abstractTariffPlanService.updateTariffPlan(id, tariffPlanDto);
    }
}
