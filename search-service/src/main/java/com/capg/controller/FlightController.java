package com.capg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.dto.FlightsDTO;
import com.capg.entity.Flights;
import com.capg.service.FightService; 

@RestController
@RequestMapping("/flights")
public class FlightController {
	@Autowired
	private FightService flightService;
	
	@PostMapping("/create")
    public ResponseEntity<FlightsDTO> createFlight(@Valid @RequestBody FlightsDTO flightsDTO) {
        return new ResponseEntity<FlightsDTO>(flightService.newFlight(flightsDTO), HttpStatus.CREATED);
    }
	
	@GetMapping("/getAll")
    public List<FlightsDTO> flights(){
        return flightService.getFlights();
    }
	
	@GetMapping("/get/{id}")
    public FlightsDTO flightById(@PathVariable Integer id) {
        return flightService.getFlight(id);
    }
	
	/*@PutMapping("/update/{id}")
    public ResponseEntity<FlightsDTO> update(@PathVariable Integer id, @Valid @RequestBody FlightsDTO flightsDTO) {
        return new ResponseEntity<FlightsDTO>(flightService.updateFlight(id, flightsDTO), HttpStatus.ACCEPTED);
    }*/
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Flights> update(@PathVariable Integer id,@RequestBody Flights user) throws Exception{
		user.setFlightId(id);
		return  ResponseEntity.ok().body(this.flightService.updateProfile(user));
	}
	
	@DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        flightService.deleteFlight(id);
        return "Flight with ID: " + id + " was deleted successfully";
    }
	
	@DeleteMapping("/deleteAll")
    public String deleteAll() {
        flightService.deleteAll();
        return "All flights were deleted successfully";
    }
	
}
