package com.reservation.springboot.data.controller;

import com.reservation.springboot.data.entity.Guest;
import com.reservation.springboot.data.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    GuestRepository guestRepository;

    @GetMapping("/all")
    public Iterable<Guest> getAllGuests(){
        return this.guestRepository.findAll();
    }
}
