package com.cts.collectionsdemo.comparators;

import java.util.Comparator;

import com.cts.collectionsdemo.model.Employee;

public class EmployeeJoinDateComparator implements Comparator<Employee>  {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getJoinDate().compareTo(o2.getJoinDate());
	}

}
