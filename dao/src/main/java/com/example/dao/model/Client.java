package com.example.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surName;
    private String address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Passport passport;


}
