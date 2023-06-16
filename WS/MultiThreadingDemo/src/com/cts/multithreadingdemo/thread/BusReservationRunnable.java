package com.cts.multithreadingdemo.thread;

import java.util.stream.Stream;

import com.cts.multithreadingdemo.model.Bus;
import com.cts.multithreadingdemo.service.BusReservationService;
import com.cts.multithreadingdemo.service.BusReservationServiceImpl;

public class BusReservationRunnable implements Runnable {

	private Bus bus;
	private int seatsNeeded;
	private String seatsReserved[];

	private BusReservationService busService;

	public BusReservationRunnable(Bus bus, int seatsNeeded) {
		super();
		this.bus=bus;
		this.seatsNeeded = seatsNeeded;
		this.seatsReserved = new String[seatsNeeded];
		this.busService = new BusReservationServiceImpl(bus);
		for (int i = 0; i < seatsNeeded; i++) {
			this.seatsReserved[i] = "Not Alloted";
		}
	}

	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		System.out.println("Reservation started for ..." + thread.getName());

		synchronized (bus) {
			for (int i = 0; i < seatsNeeded && busService.isASeatAvailable(); i++) {
				seatsReserved[i] = "Seat#" + busService.reserveASeat() + " Reserved";
				try {
					thread.sleep(500);
				} catch (InterruptedException exp) {
					exp.printStackTrace();
				}
			}
		}
	}

	public String[] getSeatsReserved() {
		return seatsReserved;
	}

}
