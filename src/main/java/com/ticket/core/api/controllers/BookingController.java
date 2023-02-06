package com.ticket.core.api.controllers;

import com.ticket.core.api.entities.Booking;
import com.ticket.core.api.payloads.BookingDto;
import com.ticket.core.api.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking/user/{userId}/seat/{seatId}")
    public ResponseEntity<BookingDto> createBooking(
            @RequestBody BookingDto bookingDto,
            @PathVariable Integer userId,
            @PathVariable Integer seatId
    )
    {
        BookingDto createdBooking = this.bookingService.createBooking(bookingDto,userId,seatId);

        return new ResponseEntity<>(createdBooking,HttpStatus.CREATED);
    }

    @GetMapping("/booking/user/{userId}/seatsavailable")
    public ResponseEntity<List<BookingDto>> getAllBooking(@PathVariable Integer userId){
        List<BookingDto> bookingList = bookingService.getAllBooking();
        return new ResponseEntity<>(bookingList,HttpStatus.OK);
    }

    @GetMapping("/booking/user/{userId}/seatsavailable/{bookedDate}")
    public ResponseEntity<List<BookingDto>> getAllBookingToday(@PathVariable Integer userId,@PathVariable String bookedDate) throws Exception{
        LocalDate date = LocalDate.parse(bookedDate);
        List<BookingDto> bookingList = bookingService.getTodayBookings(date);
        return new ResponseEntity<>(bookingList,HttpStatus.OK);
    }
}
