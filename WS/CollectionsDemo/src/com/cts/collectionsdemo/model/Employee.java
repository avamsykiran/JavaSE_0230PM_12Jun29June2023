package com.cts.collectionsdemo.model;

import java.time.LocalDate;
import java.util.Objects;

public class Employee implements Comparable<Employee> {

	private Long empId;
	private String fullName;
	private Double salary;
	private LocalDate joinDate;

	@Override
	public int compareTo(Employee o) {
		return this.empId.compareTo(o.empId);
	}
	
	public Employee() {
		
	}

	public Employee(Long empId, String fullName, Double salary, LocalDate joinDate) {
		super();
		this.empId = empId;
		this.fullName = fullName;
		this.salary = salary;
		this.joinDate = joinDate;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empId, fullName, joinDate, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(empId, other.empId) && Objects.equals(fullName, other.fullName)
				&& Objects.equals(joinDate, other.joinDate) && Objects.equals(salary, other.salary);
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", fullName=" + fullName + ", salary=" + salary + ", joinDate=" + joinDate
				+ "]";
	}

	
	
	
}
