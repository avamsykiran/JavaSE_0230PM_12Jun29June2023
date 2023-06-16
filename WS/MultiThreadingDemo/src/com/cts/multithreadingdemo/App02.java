package com.cts.multithreadingdemo;

import java.util.stream.Stream;

import com.cts.multithreadingdemo.model.Bus;
import com.cts.multithreadingdemo.thread.BusReservationRunnable;

public class App02 {

	public static void main(String[] args) {
		
		Bus bus = new Bus(25);
		
		BusReservationRunnable r1 = new BusReservationRunnable(bus, 10);
		BusReservationRunnable r2 = new BusReservationRunnable(bus, 10);
		BusReservationRunnable r3 = new BusReservationRunnable(bus, 10);
		
		Thread t1 = new Thread(r1, "RAMA");
		Thread t2 = new Thread(r2, "RAGHAV");
		Thread t3 = new Thread(r3, "RAJIV");
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println("For "+t1.getName());
		Stream.of(r1.getSeatsReserved()).forEach(System.out::println);

		System.out.println("For "+t2.getName());
		Stream.of(r2.getSeatsReserved()).forEach(System.out::println);

		System.out.println("For "+t3.getName());
		Stream.of(r3.getSeatsReserved()).forEach(System.out::println);
	}
}
