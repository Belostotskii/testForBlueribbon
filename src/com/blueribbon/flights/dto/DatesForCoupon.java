package com.blueribbon.flights.dto;

public class DatesForCoupon {
	int couponID;
	double price;

	public DatesForCoupon(int couponID, double price) {
		super();
		this.couponID = couponID;
		this.price = price;
	}

	public DatesForCoupon() {

	}

	public int getCouponID() {
		return couponID;
	}

	public double getPrice() {
		return price;
	}

}
