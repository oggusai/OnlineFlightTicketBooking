package com.FlightTicketBooking.service;

import com.FlightTicketBooking.exception.NotFoundException;
import com.FlightTicketBooking.model.dto.PilotDto;
import com.FlightTicketBooking.model.entity.Pilot;
import com.FlightTicketBooking.model.request.CreateUpdatePilotRequest;
import com.FlightTicketBooking.repository.PilotRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.FlightTicketBooking.model.mapper.PilotMapper.PILOT_MAPPER;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PilotService {
    private final PilotRepository repository;

    public PilotDto createPilot(CreateUpdatePilotRequest request){
        Pilot pilot=PILOT_MAPPER.createPilot(request);
        return PILOT_MAPPER.toPilotDto(repository.save(pilot));
    }
    public PilotDto updatePilot(int id, CreateUpdatePilotRequest request){
        Pilot pilot=repository.findById(id).orElseThrow(()->new NotFoundException("Pilot   not found."));
        PILOT_MAPPER.updatePilot(pilot,request);
        Pilot updatedpilot=repository.save(pilot);
        return PILOT_MAPPER.toPilotDto(updatedpilot);
    }
    public PilotDto getPilotById(int id){
        return PILOT_MAPPER.toPilotDto(repository.findById(id).orElseThrow(()-> new NotFoundException("Pilot   not found.")));
    }
    public List<PilotDto> getPilotList(){
        return  PILOT_MAPPER.toPilotDtoList(repository.findAll());
    }

    public void deletePilot(int id){
        repository.deleteById(id);
    }

    public void setAvailabilty(int id){
        repository.setAvailable(id,false);
    }
}
