package com.capg.bookingmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.bookingmicroservice.entity.Flights;

@Service
public class FlightsInfo {
	
	@Autowired
    private RestTemplate restTemplate;

     
    public Flights getFlightDetails(int flightId) {
        Flights flights = restTemplate.getForObject("http://search-microservice/flights/get/" + flightId,
                Flights.class);
        return flights;
    }

}
