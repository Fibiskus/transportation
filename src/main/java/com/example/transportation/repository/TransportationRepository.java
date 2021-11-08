package com.example.transportation.repository;

import com.example.transportation.entity.Transportation;
import org.springframework.data.repository.CrudRepository;

public interface TransportationRepository extends CrudRepository<Transportation, Long> {
}
