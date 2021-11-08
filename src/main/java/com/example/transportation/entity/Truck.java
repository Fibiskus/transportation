package com.example.transportation.entity;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "trucks")
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "truckID")
    private Long truckID;

    @Column(name = "truckNumber")
    private String truckNumber;

    @Column(name = "loadCapacity")
    private String loadCapacity;

    @Column(name = "driver")
    private String driver;
}

