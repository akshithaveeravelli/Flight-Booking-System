package com.capg.entity;
 
 

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.capg.dto.FlightsDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "SMSdetails")
public class Flights {
	
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private Integer flightId;
 
	private String flightName;
	
	private String origin;
	
	private String destination;
	
	private String departureTime;
	
	private String arrivalTime;
	
	private Integer seats;
	
	private Integer fare;
	
	public Flights(FlightsDTO flightsDTO) {
		this.flightId = flightsDTO.getFlightId();
        this.flightName = flightsDTO.getFlightName();
        this.origin = flightsDTO.getOrigin();
        this.destination = flightsDTO.getDestination();
        this.departureTime = flightsDTO.getDepartureTime();
        this.arrivalTime = flightsDTO.getArrivalTime();
        this.seats = flightsDTO.getSeats();
        this.fare = flightsDTO.getFare();
	}
	
	

}
