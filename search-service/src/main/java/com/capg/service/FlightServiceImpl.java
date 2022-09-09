package com.capg.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dto.FlightsDTO;
import com.capg.entity.Flights;
import com.capg.exception.FlightNotFoundException;
import com.capg.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FightService {
	
	 @Autowired
	 private FlightRepository flightRepository;
	 
	 @Autowired
	 private SequenceGeneratorService sequenceGeneratorService;
	 
	 @Override
	 public List<FlightsDTO> getFlights() {
		 List<Flights> flights = flightRepository.findAll();
		 return flights.stream().map(FlightsDTO::new).collect(Collectors.toList());
	 }
	 @Override
	 public FlightsDTO getFlight(Integer id) {
		 Flights flights = flightRepository.findById(id)
	                .orElseThrow(() -> new FlightNotFoundException("Flight does not exist with id: " + id));
		 return new FlightsDTO(flights);
	 }
	 
	 @Override
	 public FlightsDTO newFlight(FlightsDTO flightsDTO) {
		 Flights flights = new Flights(flightsDTO);
		 flights.setFlightId(sequenceGeneratorService.getSequenceNumber(Flights.SEQUENCE_NAME));
		 return new FlightsDTO(flightRepository.save(flights));
	 }
	 
	 
	 @Override
		public Flights updateProfile(Flights flights) throws Exception {
			Optional<Flights> user = this.flightRepository.findById(flights.getFlightId());
			if (user.isPresent()) {
				Flights userUpdate = user.get();
				userUpdate.setFlightName(flights.getFlightName());
				userUpdate.setOrigin(flights.getOrigin());
		 		userUpdate.setDestination(flights.getDestination());
				userUpdate.setDepartureTime(flights.getDepartureTime());
				userUpdate.setArrivalTime(flights.getArrivalTime());
				userUpdate.setSeats(flights.getSeats());
				userUpdate.setFare(flights.getFare());
				flightRepository.save(userUpdate);
		        return userUpdate;
		    } else {
		        throw new Exception("Record not found with id : " + flights.getFlightId());
		    }
		}
	 @Override
	 public void deleteFlight(Integer id) {
	        Flights flights = flightRepository.findById(id)
	                .orElseThrow(() -> new FlightNotFoundException("Flight does not exist with id: " + id));
	        flightRepository.delete(flights);
	    } 
	    @Override
	    public void deleteAll() {
	        flightRepository.deleteAll();
	    }
}
	 
	 
	 
	 
	 
	 
	 
	 
	
	


