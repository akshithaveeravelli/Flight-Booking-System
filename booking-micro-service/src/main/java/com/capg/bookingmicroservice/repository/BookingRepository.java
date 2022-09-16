package com.capg.bookingmicroservice.repository;
  

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capg.bookingmicroservice.entity.BookingDetails;

@Repository
public interface BookingRepository extends MongoRepository<BookingDetails, Integer>{
	
	 
	
}