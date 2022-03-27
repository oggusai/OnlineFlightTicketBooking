package com.FlightTicketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FlightTicketBooking.model.entity.AirlineCompany;

public interface AirlineCompanyRepository extends JpaRepository<AirlineCompany,Integer> {
}
