package com.blueribbon.flights.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import com.blueribbon.flights.dto.Baggage;
import com.blueribbon.flights.dto.Ticket;

public class FlightsEmbedded implements IFlights {

	private static final double MIN_DISCOUNT = 10;
	private static final double MAX_DISCOUNT = 90;
	private static final String NO_COUPON = "coupon doesn' found";
	private static final int NUMBER_OF_COUPONS = 100;
	private final HashMap<Integer, Ticket> tickets = new HashMap<>();
	private final HashMap<String, Baggage> baggages = new HashMap<>();
	private List<Integer> couponsList = new ArrayList<>(NUMBER_OF_COUPONS);

	@Override
	public boolean isTicketAvailable(int ticketId) {
		return tickets.containsKey(ticketId) ? true : false;
	}

	@Override
	public boolean isCheckIn(int destination, String baggageId) {
		return (baggages.containsKey(baggageId) && baggages.get(baggageId).getTicket().getDestination() == destination)
				? true
				: false;
	}

	@Override
	public String isCouponValid(int couponId, double price) {
		if (couponsList.contains(couponId)) {
			StringBuilder builder = new StringBuilder();
			builder.append("new price is ").append(price * MIN_DISCOUNT + (int) (Math.random() * MAX_DISCOUNT));
			return builder.toString();
		}
		return NO_COUPON;
	}

	@Override
	public void setCouponsList(List<Integer> coupons) {
		couponsList = coupons;

	}

}
