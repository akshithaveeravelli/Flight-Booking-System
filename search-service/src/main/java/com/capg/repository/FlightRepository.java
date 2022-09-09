package com.capg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capg.entity.Flights;
@Repository
public interface FlightRepository extends MongoRepository<Flights, Integer> {
	

}
