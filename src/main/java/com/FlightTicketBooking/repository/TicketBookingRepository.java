package com.FlightTicketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FlightTicketBooking.model.entity.TicketBooking;

import java.util.List;

public interface TicketBookingRepository extends JpaRepository<TicketBooking,Integer> {
    List<TicketBooking> findByFlightId(int id) ;
}
