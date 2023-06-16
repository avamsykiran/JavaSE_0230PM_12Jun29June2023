package com.cts.multithreadingdemo.service;

public interface BusReservationService {
	boolean isASeatAvailable();
	boolean isBusFull();
	int reserveASeat();
}
