package com.example.demo_rest.exception;

public class InvalidTicketIDException extends RuntimeException{
	public InvalidTicketIDException(String message) {
		super(message);
	}

}
