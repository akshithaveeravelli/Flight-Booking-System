package com.capg.bookingmicroservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.bookingmicroservice.dto.BookingDetailsDTO;
import com.capg.bookingmicroservice.entity.BookingDetails;
import com.capg.bookingmicroservice.exception.BookingIdNotFoundException;
import com.capg.bookingmicroservice.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired
    private FlightsInfo flightsInfo;

	@Override
	public BookingDetailsDTO newBooking(@Valid BookingDetailsDTO bookingDetailsDTO) {
		BookingDetails bookingDetails = new BookingDetails(bookingDetailsDTO);
		bookingDetails.setBookingId(sequenceGeneratorService.getSequenceNumber(BookingDetails.SEQUENCE_NAME));
		bookingDetails.setFlights(flightsInfo.getFlightDetails(bookingDetails.getFlightId()));
		bookingDetails.bookedTime();
		bookingDetails.updatedTime();
		return new BookingDetailsDTO(bookingRepository.save(bookingDetails));
	}

	@Override
	public List<BookingDetailsDTO> getBookingDetails() {
		List<BookingDetails> bookingDetails = bookingRepository.findAll();
		return bookingDetails.stream().map(BookingDetailsDTO::new).collect(Collectors.toList());
	}

	@Override
	public BookingDetailsDTO getBookingDetailsById(Integer id) {
		BookingDetails bookingDetails = bookingRepository.findById(id)
				.orElseThrow(() -> new BookingIdNotFoundException("Booking details do not exist for id: " + id));
		return new BookingDetailsDTO(bookingDetails);
	}

	@Override
	public BookingDetailsDTO updateBookingDetails(Integer id, BookingDetailsDTO bookingDetailsDTO) {
		BookingDetails bookingDetails = bookingRepository.findById(id)
				.orElseThrow(() -> new BookingIdNotFoundException("Booking details do not exist for id: " + id));

		Optional<BookingDetails> optionalBookingDetails = bookingRepository.findById(id);
		bookingRepository.delete(bookingDetails);

		if (optionalBookingDetails.isPresent()) {
			BookingDetails bookingSave = optionalBookingDetails.get();

			bookingSave.setBookingId(bookingDetails.getBookingId());
			bookingSave.setFirstName(bookingDetailsDTO.getFirstName() != null ? bookingDetailsDTO.getFirstName()
					: bookingSave.getFirstName());
			bookingSave.setLastName(bookingDetailsDTO.getLastName() != null ? bookingDetailsDTO.getLastName()
					: bookingSave.getLastName());
			bookingSave.setGender(
					bookingDetailsDTO.getGender() != null ? bookingDetailsDTO.getGender() : bookingSave.getGender());
			bookingSave.setEmail(
					bookingDetailsDTO.getEmail() != null ? bookingDetailsDTO.getEmail() : bookingSave.getEmail());
			bookingSave.setPhoneNo(
					bookingDetailsDTO.getPhoneNo() != null ? bookingDetailsDTO.getPhoneNo() : bookingSave.getPhoneNo());
			bookingSave.setRequiredSeats(
					bookingDetailsDTO.getRequiredSeats() != null ? bookingDetailsDTO.getRequiredSeats()
							: bookingSave.getRequiredSeats());
			bookingSave.setFlightId(bookingDetailsDTO.getFlightId() !=0 ? bookingDetailsDTO.getFlightId():bookingSave.getFlightId());
			bookingSave.setFlights(bookingDetailsDTO.getFlights() != null ? bookingDetailsDTO.getFlights() : flightsInfo.getFlightDetails(bookingSave.getFlightId()));

			bookingSave.setBookedOn(bookingDetails.getBookedOn());
			bookingSave.updatedTime();
			bookingRepository.save(bookingSave);
			return new BookingDetailsDTO(bookingSave);
		}
		return new BookingDetailsDTO(bookingDetails);
	}

	@Override
	public void deleteBookingDetailsById(Integer id) {
		BookingDetails bookingDetails = bookingRepository.findById(id)
				.orElseThrow(() -> new BookingIdNotFoundException("Booking details do not exist for id: " + id));
		bookingRepository.delete(bookingDetails);

	}

	@Override
	public void deleteAll() {
		bookingRepository.deleteAll();
	}

}
