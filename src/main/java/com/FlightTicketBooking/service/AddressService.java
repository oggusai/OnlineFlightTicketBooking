package com.FlightTicketBooking.service;

import com.FlightTicketBooking.exception.BussinesException;
import com.FlightTicketBooking.exception.NotFoundException;
import com.FlightTicketBooking.model.dto.AddressDto;
import com.FlightTicketBooking.model.entity.Address;
import com.FlightTicketBooking.model.request.CreateUpdateAddressRequest;
import com.FlightTicketBooking.repository.AddressRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.FlightTicketBooking.model.mapper.AddressMapper.ADDRESS_MAPPER;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository repository;

    public AddressDto createAddress(CreateUpdateAddressRequest request){
        Address address=ADDRESS_MAPPER.createAddress(request);
        return ADDRESS_MAPPER.toAddressDto(repository.save(address));
    }
    public AddressDto updateAddress(int id ,CreateUpdateAddressRequest request){
        Address address=repository.findById(id).orElseThrow(()->new NotFoundException("Not Found"));
        ADDRESS_MAPPER.updateAddress(address,request);

        Address updatedAddress=repository.save(address);
        return ADDRESS_MAPPER.toAddressDto(updatedAddress);
    }
    public AddressDto getAddressById(int id){
        return ADDRESS_MAPPER.toAddressDto(repository.findById(id).orElseThrow(()->new NotFoundException("Address Not Found")));
    }
    public List<AddressDto> getAddressList(){
        return ADDRESS_MAPPER.toAddressDtoList(repository.findAll());
    }

    public void deleteAddress(int id){
        repository.deleteById(id);
    }

    public Address toAddress(int id){
        return repository.findById(id).orElseThrow(()->new BussinesException(""));
    }


}
