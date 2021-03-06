package com.example.RestaurantGeoSearch;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="restaurents")
public class Restaurent {
	
	@Id
	private String id;	
	
	private String name;
	
	private Address address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
		return "Restaurent [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	

	
}
