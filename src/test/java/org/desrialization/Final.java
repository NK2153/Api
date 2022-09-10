package org.desrialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Final {
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
	
	File f = new File("C:\\Users\\ELCOT\\eclipse-workspace\\APIOne\\src\\test\\resources\\SimpleJSON\\simpleone.JSON");
	ObjectMapper om = new ObjectMapper();
	
	One value = om.readValue(f, One.class);
	String name = value.getName();
	System.out.println(name);
	
	int id = value.getId();
	System.out.println(id);
	
	String role = value.getRole();
	System.out.println(role);
	
	ArrayList<String> cources = value.getCources();
	for (int i = 0; i < cources.size(); i++) {
		System.out.println(cources.get(i));
	}
	
	ArrayList<Two> address = value.getAddress();
	for (int i = 0; i < address.size(); i++) {
		System.out.println(address.get(i).getCity());
		System.out.println(address.get(i).getState());
		System.out.println(address.get(i).getCountry());
	}
	
	
}
}