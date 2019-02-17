package com.blueribbon.flights.model;

import java.util.List;

public interface IFlights {

	boolean isTicketAvailable(int ticketId);

	boolean isCheckIn(int destination, String baggageId);

	String isCouponValid(int couponId, double price);

	void setCouponsList(List<Integer> coupons);
}
