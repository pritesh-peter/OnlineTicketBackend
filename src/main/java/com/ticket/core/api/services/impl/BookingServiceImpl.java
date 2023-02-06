package com.ticket.core.api.services.impl;

import com.ticket.core.api.entities.Booking;
import com.ticket.core.api.entities.Seats;
import com.ticket.core.api.entities.User;
import com.ticket.core.api.payloads.BookingDto;
import com.ticket.core.api.repositories.BookingRepo;
import com.ticket.core.api.repositories.SeatRepo;
import com.ticket.core.api.repositories.UserRepo;
import com.ticket.core.api.services.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SeatRepo seatRepo;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public BookingDto createBooking(BookingDto bookingDto,Integer userId, Integer seatId) {

        User user = userRepo.findById(userId).get();
        Seats seat = seatRepo.findById(seatId).get();
//        System.out.println("User detail"user);
//        System.out.println("Seat detail"seat);
//        System.out.println("Booking detail"+booking);


        Booking booking = modelMapper.map(bookingDto,Booking.class);

        booking.setUser(user);
        booking.setSeat(seat);

        Booking savedBooking =  this.bookingRepo.save(booking);

        BookingDto addedBookingDto = modelMapper.map(savedBooking,BookingDto.class);
        return addedBookingDto;
    }

    @Override
    public List<BookingDto> getAllBooking() {
        List<Booking> bookings = this.bookingRepo.findAll();
        List<BookingDto> bookingDtos = bookings.stream().map((booking)->this.modelMapper.map(booking,BookingDto.class)).collect(Collectors.toList());

        return bookingDtos;
    }

    @Override
    public List<BookingDto> getTodayBookings(LocalDate bookedDate) {
        List<Booking> bookings = this.bookingRepo.findAllByBookedDate(bookedDate);
        List<BookingDto> bookingDtos = bookings.stream().map((booking)->this.modelMapper.map(booking,BookingDto.class)).collect(Collectors.toList());

        return bookingDtos;
    }

}
