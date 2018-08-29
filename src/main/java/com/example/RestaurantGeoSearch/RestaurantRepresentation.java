package com.example.RestaurantGeoSearch;

public class RestaurantRepresentation {
	
	private String name;
	
	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "RestaurantRepresentation [name=" + name + ", address=" + address + "]";
	}
	
	
	
	

}
