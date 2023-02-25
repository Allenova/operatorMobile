package com.example.controller;

import com.example.service.AbstractContractService;
import com.example.service.dto.ContractDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("api/contracts")
public class ContractController {

    private final AbstractContractService abstractContractService;

    @PostMapping("/saveContract")
    public ContractDto save(@RequestBody ContractDto contractDto) {
        return abstractContractService.save(contractDto);
    }

    @DeleteMapping("/deleteContract")
    public void deleteContract(@RequestParam Long id) {
        abstractContractService.deleteContract(id);
    }

    @GetMapping("/getAll")
    public List<ContractDto> getAllContract() {
        return abstractContractService.getAllContract();
    }

    @PatchMapping("/updateContract")
   public ContractDto updateContract(@RequestParam Long id,@RequestBody ContractDto contractDto) {
        return abstractContractService.updateContract(id, contractDto);
    }
}
