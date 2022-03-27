package com.FlightTicketBooking.model.mapper;

import com.FlightTicketBooking.model.dto.PilotDto;
import com.FlightTicketBooking.model.entity.Pilot;
import com.FlightTicketBooking.model.request.CreateUpdatePilotRequest;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PilotMapper {
    PilotMapper PILOT_MAPPER= Mappers.getMapper(PilotMapper.class);

    PilotDto toPilotDto(Pilot pilot);

    List<PilotDto> toPilotDtoList(List<Pilot> pilotList);

    Pilot createPilot(CreateUpdatePilotRequest request);

    void  updatePilot(@MappingTarget Pilot pilot,CreateUpdatePilotRequest request);

}
