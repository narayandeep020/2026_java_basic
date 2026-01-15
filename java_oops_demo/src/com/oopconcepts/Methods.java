package com.oopconcepts;

public class Methods {
	// Instance variables
	private String name;
	private float salary;

// Constructor 
	public Methods(String name, float salary) {
		this.name = name;
		this.salary = salary;
	}

// getter method
	public String getName() {
		return name;
	}

	public float getSalary() {
		return salary;
	}

// setter method
	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

// Instance method
	public void displayDetail() {
		System.out.println("Employee: " + name);
		System.out.println("Salary: " + salary);
	}

	public static void main(String[] args) {
		Methods ms = new Methods("Datta", 22000);
		ms.displayDetail();

	}

}
