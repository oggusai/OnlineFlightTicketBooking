package com.FlightTicketBooking.model.dto;


import com.FlightTicketBooking.model.entity.Country;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityDto {
    private int id;

    private String cityName;

    private int  countryId;
}
