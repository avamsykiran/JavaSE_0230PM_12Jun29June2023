package com.cts.collectionsdemo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import com.cts.collectionsdemo.comparators.EmployeeFullNameComparator;
import com.cts.collectionsdemo.model.Employee;

public class App2 {

	public static void main(String[] args) {

		//Set<Employee> emps = new HashSet<>();
		//Set<Employee> emps = new LinkedHashSet<>();
		//Set<Employee> emps = new TreeSet<>();
		Set<Employee> emps = new TreeSet<>(new EmployeeFullNameComparator());
		
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

		for (Employee emp : emps) {
			System.out.println(emp);
		}
	}

}
