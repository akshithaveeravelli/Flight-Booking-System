package com.capg.bookingmicroservice.service;

import java.util.List;

import javax.validation.Valid; 

import com.capg.bookingmicroservice.dto.BookingDetailsDTO;

public interface BookingService {

	BookingDetailsDTO newBooking(@Valid BookingDetailsDTO bookingDetailsDTO);

	List<BookingDetailsDTO> getBookingDetails();

	BookingDetailsDTO getBookingDetailsById(Integer id);

	BookingDetailsDTO updateBookingDetails(Integer id, @Valid BookingDetailsDTO bookingDetailsDTO);

	void deleteBookingDetailsById(Integer id);

	void deleteAll();
 
}
