package com.capg.bookingmicroservice.exception;

public class BookingIdNotFoundException extends RuntimeException {

    public BookingIdNotFoundException (String message) {
        super(message);
    }
}
