package com.blueribbon.flights.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blueribbon.flights.dto.DatesForBaggage;
import com.blueribbon.flights.dto.DatesForCoupon;
import com.blueribbon.flights.model.IFlights;

import static com.blueribbon.flights.dto.FlightsConstants.*;

@RestController
public class FlightsController {

	private static Random rnd = new Random();

	@Autowired
	IFlights flights;

	@Value("${numberCoupons:10}")
	int numberCoupons;

	@PostConstruct
	public void set() {
		List<Integer> list = new ArrayList<>(numberCoupons);
		for (int i = 0; i < numberCoupons; i++) {
			list.add(rnd.nextInt(1000));
		}
		flights.setCouponsList(list);
	}

	@GetMapping(value = TICKET + "/{ticketId}")
	boolean ticket(@PathVariable("ticketId") Integer ticketId) {
		return flights.isTicketAvailable(ticketId);
	}

	@GetMapping(value = BAGGAGE)
	boolean coupon(@RequestBody DatesForBaggage baggage) {
		return flights.isCheckIn(baggage.getDestId(), baggage.getId());
	}

	@GetMapping(value = COUPON)
	String coupon(@RequestBody DatesForCoupon coupon) {
		return flights.isCouponValid(coupon.getCouponID(), coupon.getPrice());
	}

}
