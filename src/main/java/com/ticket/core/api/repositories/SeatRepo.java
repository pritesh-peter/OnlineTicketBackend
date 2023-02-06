package com.ticket.core.api.repositories;

import com.ticket.core.api.entities.Seats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepo extends JpaRepository<Seats,Integer> {

}
