package com.example.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Data
public class TariffPlanDto implements Serializable {
    private Long id;
    private String name;
    private Long freeMinute;
    private Double price;
    private Boolean isArchive;
}
