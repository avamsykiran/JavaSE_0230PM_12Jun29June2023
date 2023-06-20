package com.cts.sald;

import java.time.LocalDateTime;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class App1 {

	public static void main(String[] args) {

		Supplier<String> companyName = () -> "Congnizant Technology Solutions";
		System.out.println(companyName.get());
		
		Supplier<String> greeting = () -> {
			String greet = "";
			
			int h = LocalDateTime.now().getHour();
			
			if(h>=3 && h<=11) greet = "Good Morning";
			else if(h>11 && h<=15) greet = "Good Noon";
			else greet="Good Evening";
			
			return greet;
		};
		System.out.println(greeting.get());
		
		Consumer<String> repeat = str -> {
			for(int i=1;i<=10;i++) {
				System.out.print(str +"\t");
			}
			System.out.println();
		};
		
		repeat.accept("VAMSY");
		
		Consumer<String> output = System.out::println;
		output.accept("Hai! How Are You?");
		
		BinaryOperator<Integer> sum = (a,b) -> a+b;
		System.out.println(sum.apply(112, 567));
		
	}

}
