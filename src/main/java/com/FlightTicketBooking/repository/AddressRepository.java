package com.FlightTicketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FlightTicketBooking.model.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Integer> {


}
