package com.FlightTicketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FlightTicketBooking.model.entity.Rotation;

public interface RotationRepository extends JpaRepository<Rotation,Integer> {
}
