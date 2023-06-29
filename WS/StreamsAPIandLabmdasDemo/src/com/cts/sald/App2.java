package com.cts.sald;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cts.sald.model.Employee;

public class App2 {

	public static void main(String[] args) {

		List<Employee> emps = new ArrayList<>();

		emps.add(new Employee(101L, "Vamsy", 7890.0, LocalDate.now().minusYears(2)));
		emps.add(new Employee(103L, "Aruna", 5890.0, LocalDate.now().minusYears(1)));
		emps.add(new Employee(111L, "Zeenath", 7890.0, LocalDate.now().minusYears(1)));
		emps.add(new Employee(231L, "Ooha", 1890.0, LocalDate.now().minusMonths(2)));
		emps.add(new Employee(102L, "Sameera", 2290.0, LocalDate.now().minusMonths(1)));
		emps.add(new Employee(110L, "Bhanu", 4490.0, LocalDate.now().minusMonths(3)));
		emps.add(new Employee(109L, "Akhila", 6690.0, LocalDate.now().minusMonths(5)));
		emps.add(new Employee(106L, "Suman", 2290.0, LocalDate.now().minusYears(12)));
		emps.add(new Employee(104L, "Amith", 8890.0, LocalDate.now().minusYears(6)));
		emps.add(new Employee(121L, "Charles", 1190.0, LocalDate.now().minusMonths(12)));


		emps.stream().forEach(System.out::println);
		System.out.println("------------------------------------------------------------------------");
		
		emps.stream().map( emp -> String.format("%s is earning rupees %.2f per month", emp.getFullName(),emp.getSalary())).forEach(System.out::println);
		System.out.println("------------------------------------------------------------------------");
		
		List<String> empNames = emps.stream().map( emp -> emp.getFullName()).collect(Collectors.toList());
		System.out.println(empNames);
		System.out.println("------------------------------------------------------------------------");
		
		emps.stream().filter( emp -> emp.getJoinDate().isBefore(LocalDate.now().minusYears(2)) ).forEach(System.out::println);
		System.out.println("------------------------------------------------------------------------");
		
		Optional<Employee> empOptionalObj = emps.stream().reduce( (e1,e2) -> e1.getSalary()>e2.getSalary()?e1:e2 );
		System.out.println(empOptionalObj.get());
		System.out.println("------------------------------------------------------------------------");
		
		
	}

}
