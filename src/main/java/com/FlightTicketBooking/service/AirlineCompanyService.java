package com.FlightTicketBooking.service;

import com.FlightTicketBooking.exception.BussinesException;
import com.FlightTicketBooking.exception.NotFoundException;
import com.FlightTicketBooking.model.dto.AirlineCompanyDto;
import com.FlightTicketBooking.model.entity.AirlineCompany;
import com.FlightTicketBooking.model.request.CreateUpdateAirlineCompanyRequest;
import com.FlightTicketBooking.repository.AirlineCompanyRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.FlightTicketBooking.model.mapper.AirlineCompanyMapper.AIRLINE_COMPANY_MAPPER;

import java.util.List;

@Service
@RequiredArgsConstructor
public class  AirlineCompanyService {

    private final AirlineCompanyRepository repository;

    public AirlineCompanyDto createAirlineCompany(CreateUpdateAirlineCompanyRequest request){
        AirlineCompany airlineCompany=AIRLINE_COMPANY_MAPPER.createAirlineCompany(request);
        return AIRLINE_COMPANY_MAPPER.toAirlaneCompanyDto(repository.save(airlineCompany));
    }
    public AirlineCompanyDto updateAirlineCompany(int id,CreateUpdateAirlineCompanyRequest request){
        AirlineCompany airlineCompany=repository.findById(id).orElseThrow(()->new NotFoundException("Not Found"));
        AIRLINE_COMPANY_MAPPER.updateAirlineCompany(airlineCompany,request);
        AirlineCompany updatedAirlineCompany=repository.save(airlineCompany);
        return AIRLINE_COMPANY_MAPPER.toAirlaneCompanyDto(updatedAirlineCompany);
    }

    public AirlineCompanyDto getAirlineCompanyById(int id){
        return AIRLINE_COMPANY_MAPPER.toAirlaneCompanyDto(repository.findById(id).orElseThrow(()->new NotFoundException("Airline Company Not Found")));
    }

    public List<AirlineCompanyDto> getAirlineCompanyList(){
        return  AIRLINE_COMPANY_MAPPER.toAirlaneCompanyDtoList(repository.findAll());
    }
    public void deleteAirlineCompany(int id){
        repository.deleteById(id);
    }

}
