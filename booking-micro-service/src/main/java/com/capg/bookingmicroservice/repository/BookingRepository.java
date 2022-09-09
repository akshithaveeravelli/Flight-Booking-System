package com.capg.bookingmicroservice.repository;
 
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capg.bookingmicroservice.entity.BookingDetails;

@Repository
public interface BookingRepository extends MongoRepository<BookingDetails, Integer>{
	
	 Optional<BookingDetails> getUserDataByEmail(String email);

	 Optional<BookingDetails> getUserDataByUsername(String username);
	
	
}