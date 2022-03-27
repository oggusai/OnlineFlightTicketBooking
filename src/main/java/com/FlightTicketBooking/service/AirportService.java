package com.FlightTicketBooking.service;

import com.FlightTicketBooking.exception.BussinesException;
import com.FlightTicketBooking.exception.NotFoundException;
import com.FlightTicketBooking.model.dto.AirportDto;
import com.FlightTicketBooking.model.entity.Airport;
import com.FlightTicketBooking.model.request.CreateUpdateAirportRequest;
import com.FlightTicketBooking.repository.AirportRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.FlightTicketBooking.model.mapper.AirportMapper.AIRPORT_MAPPER;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportService {
    private final AirportRepository repository;

    public AirportDto createAirport(CreateUpdateAirportRequest request){
        Airport airport=AIRPORT_MAPPER.createAirport(request);
        return AIRPORT_MAPPER.toAirportDto(repository.save(airport));
    }
    public AirportDto updateAirport(int id,CreateUpdateAirportRequest request){
        Airport airport=repository.findById(id).orElseThrow(()->new BussinesException("Airport is not found."));
        AIRPORT_MAPPER.updateAirport(airport,request);
        Airport updatedAirport=repository.save(airport);
        return AIRPORT_MAPPER.toAirportDto(updatedAirport);
    }
    public AirportDto getAirportById(int id){
        return AIRPORT_MAPPER.toAirportDto(repository.findById(id).orElseThrow(()-> new NotFoundException("Airport   not found.")));
    }
    public List<AirportDto> getAirportList(){
        return  AIRPORT_MAPPER.toAirportDtoList(repository.findAll());
    }
    public void deleteAirport(int id){
        repository.deleteById(id);
    }



}
