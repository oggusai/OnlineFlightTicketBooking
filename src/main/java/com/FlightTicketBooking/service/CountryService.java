package com.FlightTicketBooking.service;

import com.FlightTicketBooking.exception.BussinesException;
import com.FlightTicketBooking.exception.NotFoundException;
import com.FlightTicketBooking.model.dto.CountryDto;
import com.FlightTicketBooking.model.entity.City;
import com.FlightTicketBooking.model.entity.Country;
import com.FlightTicketBooking.model.request.CreateUpdateCountryRequest;
import com.FlightTicketBooking.repository.CountryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.FlightTicketBooking.model.mapper.CountryMapper.COUNTRY_MAPPER;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository repository;

    public CountryDto createCountry(CreateUpdateCountryRequest request){
        Country country=COUNTRY_MAPPER.createCountry(request);
        return COUNTRY_MAPPER.toCountryDto(repository.save(country));
    }
    public CountryDto updateCountry(int id,CreateUpdateCountryRequest request){
        Country country=repository.findById(id).orElseThrow(()->new BussinesException("Country is not found."));
        COUNTRY_MAPPER.updateCountry(country,request);
        Country updatedcountry=repository.save(country);
        return COUNTRY_MAPPER.toCountryDto(updatedcountry);
    }
    public CountryDto getCountryById(int id){
        return COUNTRY_MAPPER.toCountryDto(repository.findById(id).orElseThrow(()-> new NotFoundException("Country   not found.")));
    }
    public List<CountryDto> getCountryList(){
        return  COUNTRY_MAPPER.toCountryDtoList(repository.findAll());
    }
    public void deleteCountry(int id){
        repository.deleteById(id);
    }
}
