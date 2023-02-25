package com.example.controller;

import com.example.service.AbstractPhoneNumberService;
import com.example.service.dto.PhoneNumberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/phoneNumbers")
public class PhoneNumberController {

    private final AbstractPhoneNumberService abstractPhoneNumberService;

    @PostMapping("/savePhoneNumber")
    public PhoneNumberDto save(@RequestBody PhoneNumberDto phoneNumberDto) {
        return abstractPhoneNumberService.save(phoneNumberDto);
    }

    @DeleteMapping("/deletePhoneNumber")
    public void delete(@RequestParam Long id) {
        abstractPhoneNumberService.delete(id);
    }

    @GetMapping("/getById")
    public PhoneNumberDto findById(@RequestParam Long id) {
        return abstractPhoneNumberService.findById(id);
    }

    @GetMapping("/getAll")
    public List<PhoneNumberDto> getAll() {
        return abstractPhoneNumberService.getAll();
    }

    @GetMapping("/getAllByNotActive")
    public List<PhoneNumberDto> findAllByNotActive(Boolean active) {
        return abstractPhoneNumberService.findAllByActive(active);
    }

    @PatchMapping("/updatePhoneNumber")
    public PhoneNumberDto updatePhoneNumber(PhoneNumberDto phoneNumberDto,Long id) {
        return abstractPhoneNumberService.updatePhoneNumber(phoneNumberDto, id);
    }
}
