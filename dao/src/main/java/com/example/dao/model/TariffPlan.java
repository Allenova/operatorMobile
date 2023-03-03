package com.example.dao.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TariffPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long freeMinute;
    private Double price;
    private Boolean isArchive;
}
