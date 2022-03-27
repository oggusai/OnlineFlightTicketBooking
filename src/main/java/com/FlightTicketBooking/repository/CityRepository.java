package com.FlightTicketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FlightTicketBooking.model.entity.City;

public interface CityRepository extends JpaRepository<City,Integer> {
}
