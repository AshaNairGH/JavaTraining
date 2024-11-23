package com.egjson;

import java.util.Arrays;

public class Person {
	
	private String name;
	private int agee;
	private Address[] addresses;
	
	public Person() {
		
	}
	public Person(String name,int age, Address[] addresses) {
		super();
		this.name = name;
		this.agee = age;		
		this.addresses = addresses;
	}
	public int getAgee() {
		return agee;
	}
	public void setAgee(int agee) {
		this.agee = agee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address[] getAddresses() {
		return addresses;
	}
	
	public void setAddresses(Address[] addresses) {
		this.addresses = addresses;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + agee + ", addresses=" + Arrays.toString(addresses) + "]";
	}
	
}
