package com.example.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Data
public class PassportDto implements Serializable {
    private Long id;
    private String uniqNumber;
    private String passportNumber;

}
