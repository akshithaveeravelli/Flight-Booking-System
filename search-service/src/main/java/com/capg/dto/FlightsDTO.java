package com.capg.dto;

import com.capg.entity.Flights;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightsDTO {
	
	private Integer flightId;
	
	private String flightName;
	
	private String origin;
	
	private String destination;
	
	private String departureTime;
	
	private String arrivalTime;
	
	private Integer seats;
	
	private Integer fare;
	
	public FlightsDTO(Flights flights) {
		this.flightId = flights.getFlightId();
        this.flightName = flights.getFlightName();
        this.origin = flights.getOrigin();
        this.destination = flights.getDestination();
        this.departureTime = flights.getDepartureTime();
        this.arrivalTime = flights.getArrivalTime();
        this.seats = flights.getSeats();
        this.fare = flights.getFare();
	}
	

}
