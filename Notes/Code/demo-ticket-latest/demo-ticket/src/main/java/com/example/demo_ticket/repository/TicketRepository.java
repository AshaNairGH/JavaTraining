package com.example.demo_ticket.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.example.demo_ticket.model.Ticket;

@Repository
public class TicketRepository {
	
	private HashMap<Integer, Ticket> tickets;
	
	public TicketRepository() {
		tickets = new HashMap<>();
		tickets.put(1, new Ticket(1,"Place1312","Place42342",111));
		tickets.put(2, new Ticket(2,"PlaceAAAA","PlaceCCCC",122));
		tickets.put(3, new Ticket(3,"PlaceDDDD","PlaceEEEE",241));

	}

	public Ticket getTicketRepo(int ticketid) {
		Ticket ticket = tickets.get(ticketid);
		return ticket;
	}
	
	public Ticket bookTicketRepo(Ticket ticket) {
		tickets.put(ticket.getId(), ticket);
		return ticket;
	}
	
	public Ticket updateTicketRepo(int tid, Ticket ticket) {
		tickets.replace(tid, ticket);
		return ticket;
	}
	
	public int cancelTicketRepo(int ticketid) {
		Ticket ticket = tickets.remove(ticketid);
		return ticketid;
	}

}
