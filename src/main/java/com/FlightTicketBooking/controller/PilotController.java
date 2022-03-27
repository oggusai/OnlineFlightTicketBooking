package com.FlightTicketBooking.controller;

import com.FlightTicketBooking.model.dto.PilotDto;
import com.FlightTicketBooking.model.request.CreateUpdatePilotRequest;
import com.FlightTicketBooking.service.PilotService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pilots")
@RequiredArgsConstructor
public class PilotController {
    
    private final PilotService service = new PilotService();
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PilotDto createPilot(@RequestBody CreateUpdatePilotRequest request){
        return service.createPilot(request);
    }
    @GetMapping("{id}")
    public PilotDto getPilot(@PathVariable int id) {
        return service.getPilotById(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping("{id}")
    public PilotDto updatePilot(@PathVariable int id, @RequestBody CreateUpdatePilotRequest request){
        return service.updatePilot(id,request);
    }

    @GetMapping
    public List<PilotDto> getPilotList() {
        return service.getPilotList();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePilot(@PathVariable  int id){
        service.deletePilot(id);
    }
}
