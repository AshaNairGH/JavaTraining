package com.example.demo_rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_rest.model.Ticket;
import com.example.demo_rest.repository.TicketRepository;

import jakarta.annotation.PostConstruct;

@Service
public class TicketService {

@Autowired
public TicketRepository ticketRepo;
//Dependency Injection
	
	public TicketService() {
		
	}
	
	@PostConstruct
	public void met() {
		//ticketRepo.met10("Name1");
		List<Ticket> lticket = ticketRepo.met9("Name2");
		for(Ticket t:lticket) {
			System.out.println("====="+t+"======");
		}
	}
	
public Ticket getTicketServ(int ticketid) {
		
		Optional<Ticket> oticket = ticketRepo.findById(ticketid);
		return oticket.get();
	}
	
	public Ticket bookTicketServ(Ticket ticket) {
		return ticketRepo.save(ticket);

	}
	
	public List<Ticket> getTicketFromToPlace(String fromplace, String toplace){
		return ticketRepo.findByFromplaceOrToplace(fromplace, toplace);
	}
	
	public List<Ticket> getEconomyTickets(String fromplace, String toplace, float price){
		return ticketRepo.findByFromplaceAndToplaceAndPriceLessThan(fromplace, toplace, price);
	}
	
	public float getAveragePrice(String fromplace) {
		List<Ticket> lticket = ticketRepo.met(fromplace);
		float avg_price = 0;
		for(Ticket t:lticket) {
			avg_price += t.getPrice();
		}
		
		avg_price = avg_price/lticket.size(); 
		
		return avg_price;
	}
	
	public Ticket updateTicketServ(int tid, Ticket ticket) {
		Ticket eticket = ticketRepo.findById(tid).get();
		eticket.setFromplace(ticket.getFromplace());
		eticket.setToplace(ticket.getToplace());
		eticket.setPrice(ticket.getPrice());
		return ticketRepo.save(eticket);
	}
	
	public Ticket cancelTicketServ(int ticketid) {
		
		Ticket ticket = ticketRepo.findById(ticketid).get();
		ticketRepo.deleteById(ticketid);
		return ticket;

	}	
}
