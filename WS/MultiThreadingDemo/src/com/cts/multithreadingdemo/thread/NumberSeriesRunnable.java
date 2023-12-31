package com.cts.multithreadingdemo.thread;

public class NumberSeriesRunnable implements Runnable {

	private int start;
	private int stop;
	
	public NumberSeriesRunnable(int start, int stop) {
		super();
		this.start = start;
		this.stop = stop;
	}

	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		String threadName = thread.getName();
		
		for(int i=start;i<=stop;i++) {
			System.out.println(threadName + ">> "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
