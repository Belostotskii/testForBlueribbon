package com.blueribbon.flights.dto;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Ticket implements Serializable {
	private int id;
	private int departure;
	private int destination;
	private String passengerName;
	private Date departureDate;

	public Ticket(int id, int departure, int destination, String passengerName, Date departureDate) {
		super();
		this.id = id;
		this.departure = departure;
		this.destination = destination;
		this.passengerName = passengerName;
		this.departureDate = departureDate;
	}

	public int getId() {
		return id;
	}

	public int getDeparture() {
		return departure;
	}

	public int getDestination() {
		return destination;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
