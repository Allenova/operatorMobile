package com.example.controller;

import com.example.service.AbstractPassportService;
import com.example.service.dto.PassportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("api/passports")
public class PassportController {

    private final AbstractPassportService abstractPassportService;

    @GetMapping("/getAll")
   public List<PassportDto> getAllPassport() {
        return abstractPassportService.getAllPassport();
    }

    @PostMapping
    public PassportDto save(@RequestBody PassportDto passportDto){
        return abstractPassportService.save(passportDto);}
}
