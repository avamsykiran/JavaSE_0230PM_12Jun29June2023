package com.cts.multithreadingdemo.service;

import com.cts.multithreadingdemo.model.Bus;

public class BusReservationServiceImpl implements BusReservationService {

	private Bus bus;
	
	public BusReservationServiceImpl(Bus bus) {
		super();
		this.bus = bus;
	}

	@Override
	public boolean isASeatAvailable() {
		return bus.getLastSeatReserved()!=bus.getSeats();
	}

	@Override
	public boolean isBusFull() {
		return bus.getLastSeatReserved()==bus.getSeats();
	}

	@Override
	public int reserveASeat() {
		int s = bus.getLastSeatReserved();
		s++;
		bus.setLastSeatReserved(s);
		return s;
	}

}
