package com.ticket.core.api.services.impl;

import com.ticket.core.api.entities.Seats;
import com.ticket.core.api.payloads.SeatsDto;
import com.ticket.core.api.repositories.SeatRepo;
import com.ticket.core.api.services.SeatsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatsServiceImpl implements SeatsService {

    @Autowired
    private SeatRepo seatRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<SeatsDto> getAllSeats() {
        List<Seats> seats = this.seatRepo.findAll();

        List<SeatsDto> seatsDtos = seats.stream().map((seat)->this.modelMapper.map(seat,SeatsDto.class)).collect(Collectors.toList());
        return seatsDtos;
    }
}
