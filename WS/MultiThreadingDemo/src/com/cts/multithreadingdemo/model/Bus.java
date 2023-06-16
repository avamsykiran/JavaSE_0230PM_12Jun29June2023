package com.cts.multithreadingdemo.model;

public class Bus {

	private int seats;
	private int lastSeatReserved;

	public Bus(int seats) {
		super();
		this.seats = seats;
		this.lastSeatReserved=0;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getLastSeatReserved() {
		return lastSeatReserved;
	}

	public void setLastSeatReserved(int lastSeatReserved) {
		this.lastSeatReserved = lastSeatReserved;
	}
	
	
}
