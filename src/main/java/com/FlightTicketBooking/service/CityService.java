package com.FlightTicketBooking.service;

import com.FlightTicketBooking.exception.BussinesException;
import com.FlightTicketBooking.exception.NotFoundException;
import com.FlightTicketBooking.model.dto.CityDto;
import com.FlightTicketBooking.model.entity.City;
import com.FlightTicketBooking.model.request.CreateUpdateCityRequest;
import com.FlightTicketBooking.repository.CityRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.FlightTicketBooking.model.mapper.CityMapper.CITY_MAPPER;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository repository;

    public CityDto createCity(CreateUpdateCityRequest request){
        City city=CITY_MAPPER.createCity(request);
        return CITY_MAPPER.toCityDto(repository.save(city));
    }
    public CityDto updateCity(int id,CreateUpdateCityRequest request){
       City city=repository.findById(id).orElseThrow(()->new BussinesException("City is not found."));
        CITY_MAPPER.updateCity(city,request);
       City updatedcity=repository.save(city);
        return CITY_MAPPER.toCityDto(updatedcity);
    }
    public CityDto getCityById(int id){
        return CITY_MAPPER.toCityDto(repository.findById(id).orElseThrow(()-> new NotFoundException("City  not found.")));
    }
    public List<CityDto> getCityList(){
        return  CITY_MAPPER.toCityDtoList(repository.findAll());
    }
    public void deleteCity(int id){
        repository.deleteById(id);
    }
}
