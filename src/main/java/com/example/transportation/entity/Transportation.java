package com.example.transportation.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "transportation")
public class Transportation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transportationID")
    private Long transportationID;

    @Column(name = "customerID")
    private String customerID;

    @Column(name = "cargoID")
    private String cargoID;

    @Column(name = "truckID")
    private String truckID;

    @Column(name = "cityID")
    private String cityID;

    @Column(name = "transportationDate")
    private String transportationDate;
}
