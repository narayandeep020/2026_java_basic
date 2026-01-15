package com.oopconcepts;

class Geeks {
	// Constructor
	Geeks(String name) {
		System.out.println("Constructor with one arg: " + name);
	}

	Geeks(String name, int age) {
		System.out.println("Constructor with two arg: " + name + " " + age); // Overloading
	}

	Geeks(long id) {
		System.out.println("Again Constructor with id: " + id);
	}
}

public class ConstOverloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Geeks("Samar");
		new Geeks("Sahar", 22);
		new Geeks(123456789);
	}

}
