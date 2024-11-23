package com.egjson;

import java.io.FileInputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJSONEg {
public static void main(String[] args) throws Exception{
	ObjectMapper omapper = new ObjectMapper();
	
	FileInputStream fis = new FileInputStream("./person.json");
	Person obj = omapper.readValue(fis, Person.class);
	
	System.out.println(obj);
}
}
