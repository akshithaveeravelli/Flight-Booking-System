package com.capg.service;

import java.util.List;

import com.capg.dto.FlightsDTO;
import com.capg.entity.Flights;

public interface FightService {
	
	List<FlightsDTO> getFlights();
    FlightsDTO getFlight(Integer id);
    FlightsDTO newFlight(FlightsDTO flightsDTO);
    //FlightsDTO updateFlight(Integer id, FlightsDTO flightsDTO);
    void deleteFlight(Integer id);
    void deleteAll();
    Flights updateProfile(Flights flights) throws Exception;

}
