package com.FlightTicketBooking.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ErrorResponse {
    private String message;
    private String exceptionType;
	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}
}
