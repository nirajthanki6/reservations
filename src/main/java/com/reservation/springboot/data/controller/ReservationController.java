package com.reservation.springboot.data.controller;

import com.reservation.springboot.data.entity.DateUtils;
import com.reservation.springboot.data.entity.Reservation;
import com.reservation.springboot.data.entity.RoomReservation;
import com.reservation.springboot.data.repository.ReservationRepository;
import com.reservation.springboot.data.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

//    @Autowired
//    ReservationRepository reservationRepository;

    @Autowired
    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getReservations(@RequestParam(value="date", required = false)String dateString, Model model){
        Date date = DateUtils.createDateFromDateString(dateString);
        List<RoomReservation> roomReservations = this.reservationService.getRoomReservationsForDate(date);
        model.addAttribute("roomReservations", roomReservations);
        return "reservations";
    }

//    @GetMapping("/all")
//    public Iterable<Reservation> getAllReservation(){
//        return this.reservationRepository.findAll();
//    }


}
