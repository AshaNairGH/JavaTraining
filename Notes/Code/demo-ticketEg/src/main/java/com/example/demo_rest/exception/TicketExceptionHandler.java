package com.example.demo_rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* to specify Handler method for an exception in this Project */
@ControllerAdvice
public class TicketExceptionHandler {

	/* whatever returned from this method is given back to client, during exeception scenario */
	@ExceptionHandler(InvalidPlaceNameException.class)
	ResponseEntity<String> handler(InvalidPlaceNameException excep){
		return new ResponseEntity<String>(excep.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidTicketIDException.class)
	ResponseEntity<String> met(InvalidTicketIDException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
}
