package com.oopconcepts;

class Employee {
	String name;
	int id;

	public Employee(String n, int id) {
		this.name = n;
		this.id = id;

	}

}

public class ConstructorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp1 = new Employee(" Maha", 101);
		Employee emp2 = new Employee(" Deva", 102);

		System.out.println(emp1.id + " : " + emp1.name);
		System.out.print(emp2.id + " : " + emp2.name);

	}

}
