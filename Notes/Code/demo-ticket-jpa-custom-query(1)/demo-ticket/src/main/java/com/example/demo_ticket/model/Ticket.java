package com.example.demo_ticket.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String username;

	@Column
	private String fromplace;
	
	@Column
	private String toplace;
	
	@Column
	private float price;

	public Ticket() {}
	
	public Ticket(int id, String from_place, String to_place, float price, String username) {
		super();
		this.id = id;
		this.fromplace = from_place;
		this.toplace = to_place;
		this.price = price;
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getFromplace() {
		return fromplace;
	}

	public void setFromplace(String fromplace) {
		this.fromplace = fromplace;
	}

	public String getToplace() {
		return toplace;
	}

	public void setToplace(String toplace) {
		this.toplace = toplace;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
