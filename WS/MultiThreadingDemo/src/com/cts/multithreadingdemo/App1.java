package com.cts.multithreadingdemo;

import com.cts.multithreadingdemo.thread.NumberSeriesRunnable;

public class App1 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new NumberSeriesRunnable(100, 120), "threadOne");
		Thread t2 = new Thread(new NumberSeriesRunnable(200, 220), "threadTwo");
		Thread t3 = new Thread(new NumberSeriesRunnable(300, 320), "threadThree");

		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Oh! we are done!");
	}

}
