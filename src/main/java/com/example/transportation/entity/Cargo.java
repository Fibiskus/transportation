package com.example.transportation.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cargoes")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cargoID")
    private Long cargoID;

    @Column(name = "cargo")
    private String cargoName;

    @Column(name = "weight")
    private String weight;
}
