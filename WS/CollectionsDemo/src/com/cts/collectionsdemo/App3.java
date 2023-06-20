package com.cts.collectionsdemo;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.cts.collectionsdemo.model.Employee;

public class App3 {

	public static void main(String[] args) {
		//Map<Long,Employee> emps = new HashMap<>();
		//Map<Long,Employee> emps = new LinkedHashMap<>();
		Map<Long,Employee> emps = new TreeMap<>();
		
		emps.put(101L,new Employee(101L, "Vamsy", 7890.0, LocalDate.now().minusYears(2)));
		emps.put(103L,new Employee(103L, "Aruna", 5890.0, LocalDate.now().minusYears(1)));
		emps.put(111L,new Employee(111L, "Zeenath", 7890.0, LocalDate.now().minusYears(1)));
		emps.put(231L,new Employee(231L, "Ooha", 1890.0, LocalDate.now().minusMonths(2)));
		emps.put(102L,new Employee(102L, "Sameera", 2290.0, LocalDate.now().minusMonths(1)));
		emps.put(110L,new Employee(110L, "Bhanu", 4490.0, LocalDate.now().minusMonths(3)));
		emps.put(109L,new Employee(109L, "Akhila", 6690.0, LocalDate.now().minusMonths(5)));
		emps.put(106L,new Employee(106L, "Suman", 2290.0, LocalDate.now().minusYears(12)));
		emps.put(104L,new Employee(104L, "Amith", 8890.0, LocalDate.now().minusYears(6)));
		emps.put(121L,new Employee(121L, "Charles", 1190.0, LocalDate.now().minusMonths(12)));
		
		Set<Long> empIds = emps.keySet();
		
		for(Long empId : empIds) {
			System.out.println(empId+"\t"+emps.get(empId));
		}
	}

}
