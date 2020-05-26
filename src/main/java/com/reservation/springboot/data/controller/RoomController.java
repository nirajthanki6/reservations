package com.reservation.springboot.data.controller;

import com.reservation.springboot.data.entity.Room;
import com.reservation.springboot.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

    @GetMapping("/all")
    public Iterable<Room> getAllRooms(){
        return this.roomRepository.findAll();
    }

}
