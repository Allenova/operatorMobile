package com.example.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Data
@EqualsAndHashCode
public class TariffPlanDto implements Serializable {
    private Long id;
    private String name;
    private Long freeMinute;
    private Double price;
    private Boolean isArchive;
}
