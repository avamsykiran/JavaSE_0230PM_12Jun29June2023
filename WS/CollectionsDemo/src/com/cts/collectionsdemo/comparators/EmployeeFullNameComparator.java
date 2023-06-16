package com.cts.collectionsdemo.comparators;

import java.util.Comparator;

import com.cts.collectionsdemo.model.Employee;

public class EmployeeFullNameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getFullName().compareTo(o2.getFullName());
	}

}
