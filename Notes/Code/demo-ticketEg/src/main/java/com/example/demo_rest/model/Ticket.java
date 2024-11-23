package com.example.demo_rest.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
	
	@NotNull(message = "Username cant be blank")
	@Column
	private String username;
	
	@Size(min= 3, max = 100)
	@NotNull
	@Column
private String fromplace;;
	
@NotNull
	@Column
private String toplace;

@NotNull
@Email
@Column
private String email;

@DecimalMin("99.9")
@DecimalMax("10000")
	@Column
private float price;

@Future(message = "Date should be in future")
private Date traveldate;

@Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$")
private String pincode;

public Ticket() {}

public Ticket(int id, @NotNull(message = "Username cant be blank") String username,
		@Size(min = 3, max = 100) @NotNull String fromplace, @NotNull String toplace, @NotNull @Email String email,
		@DecimalMin("99.9") @DecimalMax("10000") float price,
		@Future(message = "Date should be in future") Date traveldate, @Pattern(regexp = "^[0-9]{6}$") String pincode) {
	super();
	this.id = id;
	this.username = username;
	this.fromplace = fromplace;
	this.toplace = toplace;
	this.email = email;
	this.price = price;
	this.traveldate = traveldate;
	this.pincode = pincode;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public float getPrice() {
	return price;
}

public void setPrice(float price) {
	this.price = price;
}


public Date getTraveldate() {
	return traveldate;
}

public void setTraveldate(Date traveldate) {
	this.traveldate = traveldate;
}

public String getPincode() {
	return pincode;
}

public void setPincode(String pincode) {
	this.pincode = pincode;
}

@Override
public String toString() {
	return "Ticket [id=" + id + ", username=" + username + ", fromplace=" + fromplace + ", toplace=" + toplace
			+ ", email=" + email + ", price=" + price + ", traveldate=" + traveldate + "]";
}




}