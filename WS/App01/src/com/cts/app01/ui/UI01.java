package com.cts.app01.ui;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UI01 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Date Of Joining (yyyy-MM-dd) ? ");
		String dojStr = scan.next();
		LocalDate doj = LocalDate.parse(dojStr,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		Period exp = Period.between(doj, LocalDate.now());
		System.out.println("Your Experience is: "+exp.getYears() +" yrs approx");

		scan.close();
	}

}
