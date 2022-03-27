package com.FlightTicketBooking.service;

 import com.FlightTicketBooking.exception.BussinesException;
import com.FlightTicketBooking.exception.NotFoundException;
import com.FlightTicketBooking.model.dto.TicketPriceDto;
import com.FlightTicketBooking.model.entity.TicketPrice;
import com.FlightTicketBooking.model.request.CreateUpdateTicketPriceRequest;
import com.FlightTicketBooking.repository.TicketPriceRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.FlightTicketBooking.model.mapper.TicketPriceMapper.TICKET_PRICE_MAPPER;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TicketPriceService {
    private final TicketPriceRepository repository;

    public TicketPriceDto createTicketPrice(CreateUpdateTicketPriceRequest request){
        TicketPrice ticketPrice=TICKET_PRICE_MAPPER.createTicketPrice(request);

        return TICKET_PRICE_MAPPER.toTicketPriceDto(repository.save(ticketPrice));
    }
    public TicketPriceDto updateTicketPrice(int id, CreateUpdateTicketPriceRequest request){
        TicketPrice rotation=repository.findById(id).orElseThrow(()->new NotFoundException("TicketPrice not found."));
        TICKET_PRICE_MAPPER.updateTicketPrice(rotation,request);
        TicketPrice updatedrotation=repository.save(rotation);
        return TICKET_PRICE_MAPPER.toTicketPriceDto(updatedrotation);
    }
    public TicketPriceDto getTicketPriceById(int id){
        return TICKET_PRICE_MAPPER.toTicketPriceDto(repository.findById(id).orElseThrow(()-> new NotFoundException("TicketPrice not found.")));
    }
    public List<TicketPriceDto> getTicketPriceList(){
        return  TICKET_PRICE_MAPPER.toTicketPriceDtoList(repository.findAll());
    }
    public void deleteTicketPrice(int id){
        repository.deleteById(id);
    }

}
