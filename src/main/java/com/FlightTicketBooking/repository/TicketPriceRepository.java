package com.FlightTicketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FlightTicketBooking.model.entity.TicketPrice;

public interface TicketPriceRepository extends JpaRepository<TicketPrice,Integer> {
}
