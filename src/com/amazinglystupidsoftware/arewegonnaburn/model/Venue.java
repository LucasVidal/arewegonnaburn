package com.amazinglystupidsoftware.arewegonnaburn.model;

public class Venue {

	private String name;
	private String location;
	private int capacity;
	
	
	public Venue(String name, String location, int capacity) {
		super();
		this.name = name;
		this.location = location;
		this.capacity = capacity;
	}
	
	public String toString()
	{
		return name + " - " + location + " capacidad: "+capacity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isValid() {
		return (
				(this.getCapacity() > 0)
				&& (this.getName() != null)
				&& (this.getLocation() != null)
				);
	}
	
    
}
