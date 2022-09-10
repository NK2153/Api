package org.desrialization;

import java.util.ArrayList;

public class One {
	private String name;
	private int id;
	private String role;
	private ArrayList<String> cources;
	private ArrayList<Two> address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public ArrayList<String> getCources() {
		return cources;
	}
	public void setCources(ArrayList<String> cources) {
		this.cources = cources;
	}
	public ArrayList<Two> getAddress() {
		return address;
	}
	public void setAddress(ArrayList<Two> address) {
		this.address = address;
	}

}
