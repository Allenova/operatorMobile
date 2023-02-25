package com.example.service.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@Data
public class ContractDto implements Serializable {
    private Long id;
    private Date date;
    private ClientDto client;
    private PhoneNumberDto phoneNumber;
    private TariffPlanDto tariffPlan;
}
