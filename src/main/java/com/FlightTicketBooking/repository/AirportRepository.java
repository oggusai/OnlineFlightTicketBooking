package com.FlightTicketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FlightTicketBooking.model.entity.Airport;

public interface AirportRepository extends JpaRepository<Airport,Integer> {
}
