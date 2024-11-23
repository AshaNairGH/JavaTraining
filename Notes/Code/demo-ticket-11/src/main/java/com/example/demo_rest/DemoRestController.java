package com.example.demo_rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
	
	//declare collection
	public DemoRestController() {
		//create collection obj
		System.out.println("Constructor DemoRestController()");
	}

	@GetMapping("/abcd")
	String met() {
		System.out.println("----jjjj---");
		return "Hello World";
	}
	
	@GetMapping("/ticket")
	//http://localhost:8180/ticket?tid=6453
	Ticket getUser(@RequestParam("tid") int ticketid){
		//get ticket with tid ticketid from collection
		return new Ticket(ticketid,"some user","some addr",3);
	}
	
	@PostMapping("/book")
	Ticket bookTicket(@RequestBody Ticket ticket) {
		System.out.println("Booking ticket: "+ticket);
		ticket.setId(100);
		return ticket;
	}
	
	@DeleteMapping("/cancel")
	String cancelTicket(@RequestParam("tid") int ticketid) {
		return "Ticket with id "+ticketid+" is cancelled";
	}
}
