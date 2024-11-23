package com.example.demo_resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/redbus")
public class DemoController {

@Autowired
DemoClientService clientService;
	
	@GetMapping("/{ticketid}")
	public ResponseEntity<Ticket> getTicket(@PathVariable int ticketid) {
		ResponseEntity<Ticket> reticket = 
				clientService.getTickets(ticketid);
		System.out.println("Received Ticket:"+reticket.getBody());
		return reticket;
	}
	
	/*
	HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("TX_XID", "eg564ssasdd");

        CatTest cat = new CatTest();
        cat.setType("TEST_CAT");
        HttpEntity<CatTest> requestEntity = new HttpEntity<CatTest>(cat,httpHeaders);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        ResponseEntity<String> result = restTemplate.postForEntity(url, requestEntity,String.class);
	 */
	@PostMapping
	public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket){
		HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("x-custom-hdr", "abcd");
        
        HttpEntity<Ticket> request = new HttpEntity<Ticket>(ticket, httpHeaders); 
		ResponseEntity<Ticket> reticket = 
				clientService.bookTicket(ticket);
	
		System.out.println("Created Ticket:"+reticket.getBody());
	return reticket;
	}
	
	@PutMapping("/{ticketid}")
	public ResponseEntity<Ticket> updateTicket(@PathVariable int ticketid, @RequestBody Ticket ticket){
		ResponseEntity<Ticket> rticket = clientService.updateTicket(ticketid, ticket);
		return rticket;
	}
	
	@DeleteMapping("/{ticketid}")
	public void cancelTicket(@PathVariable int ticketid){
		clientService.cancelTicket(ticketid);
		
	}
	
	
}
