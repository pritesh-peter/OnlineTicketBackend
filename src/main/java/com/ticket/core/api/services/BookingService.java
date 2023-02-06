package com.ticket.core.api.services;

import com.ticket.core.api.entities.Booking;
import com.ticket.core.api.payloads.BookingDto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface BookingService {

    BookingDto createBooking(BookingDto bookingDto,Integer userId, Integer seatId);

    List<BookingDto> getAllBooking();

    List<BookingDto> getTodayBookings(LocalDate bookedDate);
}
