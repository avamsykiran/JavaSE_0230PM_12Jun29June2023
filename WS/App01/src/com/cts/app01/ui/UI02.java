package com.cts.app01.ui;

import java.util.Scanner;

public class UI02 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter amt");
		double amount = sc.nextDouble();

		System.out.println("enter loan tearm");
		int time = sc.nextInt();

		System.out.println("enter interst rate");
		float interstRate = sc.nextFloat();

		Double emi = (amount * interstRate * (float) Math.pow(1 + interstRate, time))
				/ (float) (Math.pow(1 + interstRate, time) - 1);

		System.out.println(emi);
		sc.close();

	}

}
