package com.FlightTicketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.FlightTicketBooking.model.entity.User;

import java.util.Optional;

public interface UserRespository extends JpaRepository<User,Integer> {
    Optional<User> findByUserEmail(String email);

}
