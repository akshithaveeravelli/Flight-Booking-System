package com.capg.bookingmicroservice.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.capg.bookingmicroservice.dto.BookingDetailsDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "BMSDetails")
public class BookingDetails {
	
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private int bookingId;

    private String firstName;
    
    private String lastName;
    
    private String gender;
    
    private String email;
    
    private String phoneNo;
    
    private Integer requiredSeats;
    
    private int flightId;
    
    private Flights flights;
    
    @CreatedDate
    private LocalDateTime bookedOn;
    
    @CreatedDate
    private LocalDateTime updatedOn;
    
    public BookingDetails(BookingDetailsDTO bookingDetailsDTO) {
    	
    	 this.bookingId = bookingDetailsDTO.getBookingId();
    	 this.firstName = bookingDetailsDTO.getFirstName();
         this.lastName = bookingDetailsDTO.getLastName();
         this.gender = bookingDetailsDTO.getGender();
         this.email = bookingDetailsDTO.getEmail();
         this.phoneNo = bookingDetailsDTO.getPhoneNo();
         this.requiredSeats = bookingDetailsDTO.getRequiredSeats();
         this.flightId = bookingDetailsDTO.getFlightId();
         this.flights = bookingDetailsDTO.getFlights();
         
         this.bookedOn = bookingDetailsDTO.getBookedOn();
         this.updatedOn = bookingDetailsDTO.getUpdatedOn();
    }
    
    public void bookedTime() {
        bookedOn = LocalDateTime.now();
    }

    public void updatedTime() {
        updatedOn = LocalDateTime.now();
    }

	 
	
	

}
