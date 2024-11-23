package com.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_ticket.exception.InvalidPlaceNameException;
import com.example.demo_ticket.exception.InvalidTicketIDException;
import com.example.demo_ticket.model.Ticket;

@RestController
@RequestMapping("/ticket")
public class TicketRestController {

	private HashMap<Integer, Ticket> tickets;

	public TicketRestController() {
		tickets = new HashMap<>();
		tickets.put(1, new Ticket(1,"Place1312","Place42342",111));
		tickets.put(2, new Ticket(2,"PlaceAAAA","PlaceCCCC",122));
		tickets.put(3, new Ticket(3,"PlaceDDDD","PlaceEEEE",241));
	}

	// GET /ticket/<ticketid>
	@GetMapping("/{tid}")
	ResponseEntity<Ticket> getTicket(@PathVariable("tid") int ticketid) {

		Ticket ticket = tickets.get(ticketid);
		
		if(ticket == null) {
			throw new InvalidTicketIDException("No such ticket  exists");
		}

		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);

	/* when ticket id doesn't exist, status code 404, Ticket doesn't exist */
	}

	// searching tickets
	// all tickets of an User

	// POST /ticket/book
	@PostMapping("/book")
	ResponseEntity<Ticket> bookTicket(@RequestBody Ticket ticket) {

		if(ticket.getTo_place() == null || ticket.getFrom_place() == null) {
			throw new InvalidPlaceNameException("Place Empty or null or doesnt Exist");
		}
		// assuming ticket id is given by client itself
		tickets.put(ticket.getId(), ticket);
		return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
	}

	// PUT /ticket/update
	@PutMapping("/update/{tid}")
	ResponseEntity<Ticket> update(@PathVariable("tid") Integer tid, @RequestBody Ticket ticket) {
		
		Integer i = 10; //Boxing, 
		//int j = new Integer(20);//Unboxing
		int j = Integer.valueOf(20);
	
		tickets.replace(tid, ticket);
		return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
	}

	// DELETE /ticket/<ticketid>
	@DeleteMapping("/{tid}")
	ResponseEntity<Integer> cancel(@PathVariable("tid") Integer ticketid) {
		Ticket ticket = tickets.remove(ticketid);
		if(ticket == null) {
			throw new InvalidTicketIDException("No such ticket  exists");
		}
		return new ResponseEntity<Integer>(ticketid, HttpStatus.CREATED);
	}
}
