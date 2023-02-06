package com.ticket.core.api.repositories;

import com.ticket.core.api.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface BookingRepo extends JpaRepository<Booking,Integer> {

   List<Booking> findAllByBookedDate(LocalDate bookedDate);
}
