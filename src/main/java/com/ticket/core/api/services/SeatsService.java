package com.ticket.core.api.services;

import com.ticket.core.api.payloads.SeatsDto;

import java.util.List;

public interface SeatsService {

    List<SeatsDto> getAllSeats();
}
