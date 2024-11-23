package com.example.demo_rest;

import org.springframework.stereotype.Component;

@Component
public class User {
private int id;
private String name;
private String addr;

public User() {}

public User(int id, String name, String addr) {
	super();
	this.id = id;
	this.name = name;
	this.addr = addr;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}




}
