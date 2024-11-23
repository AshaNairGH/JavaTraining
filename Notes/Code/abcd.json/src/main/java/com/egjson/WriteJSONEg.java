package com.egjson;

import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class WriteJSONEg {
public static void main(String[] args) throws Exception {
	
	//Address addr = new Address("street1", "city1", 654765);
	Address[] addr = {new Address("street1", "city1", 654765),new Address("street2", "city2", 654766)};
	Person obj = new Person("Ravi", 46, addr);
	//obj.setAge(46);
	//obj.setName("Ravi");
	
	ObjectMapper mapper = new ObjectMapper();
	
	FileOutputStream fos = new FileOutputStream("person.json");
	
	mapper.writeValue(fos, obj);
	String pjson = mapper.writeValueAsString(obj);
	
	System.out.println("Json file has been created, please check.");
}
}
