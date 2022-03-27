package com.FlightTicketBooking.model.mapper;


import com.FlightTicketBooking.model.dto.AddressDto;
import com.FlightTicketBooking.model.entity.Address;
import com.FlightTicketBooking.model.request.CreateUpdateAddressRequest;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressMapper ADDRESS_MAPPER= Mappers.getMapper(AddressMapper.class);

    AddressDto toAddressDto(Address address);

    List<AddressDto> toAddressDtoList(List<Address> addressList);

    Address createAddress(CreateUpdateAddressRequest request);

    void  updateAddress(@MappingTarget Address address,CreateUpdateAddressRequest request);

}
