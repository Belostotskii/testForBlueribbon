package com.blueribbon.flights.dto;

public class DatesForBaggage {

	String id;
	int destId;

	public DatesForBaggage(String id, int destId) {
		super();
		this.id = id;
		this.destId = destId;
	}

	public DatesForBaggage() {

	}

	public String getId() {
		return id;
	}

	public int getDestId() {
		return destId;
	}

}
