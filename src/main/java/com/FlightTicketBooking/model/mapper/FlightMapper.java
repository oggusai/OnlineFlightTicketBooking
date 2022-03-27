package com.FlightTicketBooking.model.mapper;

import com.FlightTicketBooking.model.dto.FlightDto;
import com.FlightTicketBooking.model.entity.Flight;
import com.FlightTicketBooking.model.request.CreateUpdateFlightRequest;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    FlightMapper FLIGHT_MAPPER= Mappers.getMapper(FlightMapper.class);

    FlightDto toFlightDto(Flight flight);

    List<FlightDto> toFlightDtoList(List<Flight> flightList);

    Flight createFlight(CreateUpdateFlightRequest request);

    void updateFlight(@MappingTarget Flight flight,CreateUpdateFlightRequest createUpdateFlightRequest);

}
