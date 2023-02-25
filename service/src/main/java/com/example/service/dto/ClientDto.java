package com.example.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@Data
public class ClientDto implements Serializable {
    private Long id;
    private String name;
    private String surName;
    private String address;
    private PassportDto passport;
}

