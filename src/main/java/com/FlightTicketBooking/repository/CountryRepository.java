package com.FlightTicketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FlightTicketBooking.model.entity.Country;

public interface CountryRepository extends JpaRepository<Country,Integer> {
}
