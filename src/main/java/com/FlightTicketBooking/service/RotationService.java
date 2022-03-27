package com.FlightTicketBooking.service;
import com.FlightTicketBooking.exception.BussinesException;
import com.FlightTicketBooking.exception.NotFoundException;
import com.FlightTicketBooking.model.dto.RotationDto;
import com.FlightTicketBooking.model.entity.Rotation;
import com.FlightTicketBooking.model.request.CreateUpdateRotationRequest;
import com.FlightTicketBooking.repository.RotationRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.FlightTicketBooking.model.mapper.RotationMapper.ROTATION_MAPPER;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RotationService {
    private final RotationRepository repository;

    public RotationDto createRotation(CreateUpdateRotationRequest request){
        validateRotation(request);
        Rotation rotation= ROTATION_MAPPER.createRotation(request);
        return ROTATION_MAPPER.toRotationDto(repository.save(rotation));
    }
    public RotationDto updateRotation(int id, CreateUpdateRotationRequest request){
        Rotation rotation=repository.findById(id).orElseThrow(()->new NotFoundException("Rotation not found."));
        ROTATION_MAPPER.updateRotation(rotation,request);
        Rotation updatedrotation=repository.save(rotation);
        return ROTATION_MAPPER.toRotationDto(updatedrotation);
    }
    public RotationDto getRotationById(int id){
        return ROTATION_MAPPER.toRotationDto(repository.findById(id).orElseThrow(()-> new NotFoundException("Rotation not found.")));
    }
    public List<RotationDto> getRotationList(){
        return  ROTATION_MAPPER.toRotationDtoList(repository.findAll());
    }

    public void deleteRotation(int id){
        repository.deleteById(id);
    }

    public void validateRotation(CreateUpdateRotationRequest request){
        int arrivalAirport=request.getArrivalAirportId();
        int departureAirport=request.getDepartureAirportId();

        if(arrivalAirport==departureAirport){
            throw new BussinesException("You cannot select same airport");
        }
    }
}
