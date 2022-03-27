package com.FlightTicketBooking.controller;

import com.FlightTicketBooking.model.dto.RotationDto;
import com.FlightTicketBooking.model.request.CreateUpdateRotationRequest;
import com.FlightTicketBooking.service.RotationService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rotations")
@RequiredArgsConstructor
public class RotationController {
    private final RotationService service = new RotationService();
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RotationDto createRotation(@RequestBody CreateUpdateRotationRequest request){
        return service.createRotation(request);
    }
    @GetMapping("{id}")
    public RotationDto getRotation(@PathVariable int id) {
        return service.getRotationById(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping("{id}")
    public RotationDto updateRotation(@PathVariable int id, @RequestBody CreateUpdateRotationRequest request){
        return service.updateRotation(id,request);
    }

    @GetMapping
    public List<RotationDto> getRotationList() {
        return service.getRotationList();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRotation(@PathVariable  int id){
        service.deleteRotation(id);
    }
}
