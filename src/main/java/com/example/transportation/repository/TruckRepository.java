package com.example.transportation.repository;

import com.example.transportation.entity.Truck;
import org.springframework.data.repository.CrudRepository;

public interface TruckRepository extends CrudRepository<Truck, Long> {
}
