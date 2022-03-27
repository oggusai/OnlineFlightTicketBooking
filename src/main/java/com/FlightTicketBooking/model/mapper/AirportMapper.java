package com.FlightTicketBooking.model.mapper;

import com.FlightTicketBooking.model.dto.AirportDto;
import com.FlightTicketBooking.model.entity.Airport;
import com.FlightTicketBooking.model.request.CreateUpdateAirportRequest;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AirportMapper {
    AirportMapper AIRPORT_MAPPER= Mappers.getMapper(AirportMapper.class);

    AirportDto toAirportDto(Airport airport);

    List<AirportDto> toAirportDtoList(List<Airport> airportList);

    Airport createAirport(CreateUpdateAirportRequest request);

    void updateAirport(@MappingTarget Airport airport,CreateUpdateAirportRequest request);

}
