package com.ticket.core.api.payloads;

import com.ticket.core.api.entities.Seats;
import com.ticket.core.api.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {

    private int id;

    private SeatsDto seat;

    private UserDto user;

    private boolean booked;

    private LocalDate bookedDate;

}
