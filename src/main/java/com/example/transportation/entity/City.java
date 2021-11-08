package com.example.transportation.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cityID")
    private Long cityID;

    @Column(name = "city")
    private String cityName;
}
