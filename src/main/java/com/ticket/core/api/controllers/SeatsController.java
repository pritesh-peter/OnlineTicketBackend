package com.ticket.core.api.controllers;

import com.ticket.core.api.payloads.SeatsDto;
import com.ticket.core.api.services.SeatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SeatsController {

    @Autowired
    private SeatsService seatsService;

    @GetMapping("/seats")
    public ResponseEntity<List<SeatsDto>> GetAllSeats(){
        List<SeatsDto> seatsDtos = this.seatsService.getAllSeats();
        return new ResponseEntity<>(seatsDtos, HttpStatus.OK);
    }
}
