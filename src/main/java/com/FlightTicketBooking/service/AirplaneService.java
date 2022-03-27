package com.FlightTicketBooking.service;

import com.FlightTicketBooking.exception.BussinesException;
import com.FlightTicketBooking.exception.NotFoundException;
import com.FlightTicketBooking.model.dto.AirplaneDto;
import com.FlightTicketBooking.model.entity.Airplane;
import com.FlightTicketBooking.model.request.CreateUpdateAirplaneRequest;
import com.FlightTicketBooking.repository.AirplaneRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.FlightTicketBooking.model.mapper.AirplaneMapper.AIRPLANE_MAPPER;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirplaneService {
    private final AirplaneRepository repository;

    public AirplaneDto createAirplane(CreateUpdateAirplaneRequest request){
        Airplane airplane=AIRPLANE_MAPPER.createAirplane(request);
        return AIRPLANE_MAPPER.toAirplaneDto(repository.save(airplane));
    }
    public AirplaneDto updateAirplane(int id ,CreateUpdateAirplaneRequest request){
        Airplane airplane=repository.findById(id).orElseThrow(()->new NotFoundException("Not Found"));
        AIRPLANE_MAPPER.updateAirplane(airplane,request);
        Airplane updatedAirplane=repository.save(airplane);
        return AIRPLANE_MAPPER.toAirplaneDto(updatedAirplane);
    }
    public AirplaneDto getAirplaneById(int id){
        return AIRPLANE_MAPPER.toAirplaneDto(repository.findById(id).orElseThrow(()->new NotFoundException("Airplane not found")));
    }
    public List<AirplaneDto> getAirplaneList(){ return AIRPLANE_MAPPER.toAirplaneDtoList(repository.findAll()); }

    public void deleteAirplane(int id){  repository.deleteById(id);}

    public void setAvailabilty(int id){
        repository.setAvailable(id,false);
    }

}
