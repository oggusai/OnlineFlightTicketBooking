package com.FlightTicketBooking.model.mapper;

import com.FlightTicketBooking.model.dto.CityDto;
import com.FlightTicketBooking.model.entity.City;
import com.FlightTicketBooking.model.request.CreateUpdateCityRequest;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {

    CityMapper CITY_MAPPER= Mappers.getMapper(CityMapper.class);

    CityDto toCityDto(City city);

    List<CityDto> toCityDtoList(List<City> cityList);

    City createCity(CreateUpdateCityRequest request);

    void updateCity(@MappingTarget City city,CreateUpdateCityRequest request);


}
