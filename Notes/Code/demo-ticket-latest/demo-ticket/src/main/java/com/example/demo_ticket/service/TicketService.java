package com.example.demo_ticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_ticket.model.Ticket;
import com.example.demo_ticket.repository.TicketRepository;
@Service
public class TicketService {
	@Autowired
	private TicketRepository ticketRepo;
	//Dependency Injection
	
	public Ticket getTicketServ(int ticketid) {
		return ticketRepo.getTicketRepo(ticketid);
	}
	
	public Ticket bookTicketServ(Ticket ticket) {
	return ticketRepo.bookTicketRepo(ticket);
	}
	
	public Ticket updateTicketServ(int tid, Ticket ticket) {
		return ticketRepo.updateTicketRepo(tid, ticket);
	}
	
	public Ticket cancelTicketRepo(int ticketid) {
		Ticket ticket = ticketRepo.getTicketRepo(ticketid);
		ticketRepo.cancelTicketRepo(ticketid);
		return ticket;
	}
}
