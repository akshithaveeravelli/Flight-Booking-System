package com.capg.bookingmicroservice.dto;

import java.time.LocalDateTime;
 
import com.capg.bookingmicroservice.entity.BookingDetails;
import com.capg.bookingmicroservice.entity.Flights;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
public class BookingDetailsDTO {
	
	private int bookingId;
	
	private String firstName;
	
    private String lastName;
    
    private String gender;
    
    private String email;
    
    private String phoneNo;
    
    private Integer requiredSeats;
    
    private int flightId;
    
    private Flights flights;
    
    private LocalDateTime bookedOn;
    
    private LocalDateTime updatedOn;

    public BookingDetailsDTO(BookingDetails bookingDetails) {
        this.bookingId = bookingDetails.getBookingId();
        this.firstName = bookingDetails.getFirstName();
        this.lastName = bookingDetails.getLastName();
        this.gender = bookingDetails.getGender();
        this.email = bookingDetails.getEmail();
        this.phoneNo = bookingDetails.getPhoneNo();
        this.requiredSeats = bookingDetails.getRequiredSeats(); 
        this.flightId = bookingDetails.getFlightId();
        this.flights = bookingDetails.getFlights();

        this.bookedOn = bookingDetails.getBookedOn();
        this.updatedOn = bookingDetails.getUpdatedOn();
    }

}
