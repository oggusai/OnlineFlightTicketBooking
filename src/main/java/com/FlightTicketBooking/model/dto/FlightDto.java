package com.FlightTicketBooking.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.FlightTicketBooking.model.entity.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightDto {
    private int id;

    private String flightCode;

    private Date depatureTime;

    private Date arrivalTime;

    private int rotationId;

    private int pilotId;

    private int airlineCompanyId;

    private int airplaneId;

    private int ticketPriceId;

    private boolean available;

    private int seatLeft;

}
