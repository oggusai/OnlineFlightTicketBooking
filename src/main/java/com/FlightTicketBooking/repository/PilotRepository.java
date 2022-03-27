package com.FlightTicketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.FlightTicketBooking.model.entity.Pilot;

public interface PilotRepository extends JpaRepository<Pilot,Integer> {
    @Modifying(clearAutomatically = true)
    @Query("update #{#entityName} p set p.available= :available where p.id= :id")
    int setAvailable(@Param("id") Integer id, @Param("available") boolean available);
}
