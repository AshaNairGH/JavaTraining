package com.example.demo_rest.exception;

public class InvalidPlaceNameException extends RuntimeException{
	public InvalidPlaceNameException(String message) {
		super(message);
	}
}
