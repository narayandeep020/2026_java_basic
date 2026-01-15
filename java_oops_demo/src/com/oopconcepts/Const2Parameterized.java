package com.oopconcepts;

public class Const2Parameterized {
	String name;
	int identity;

	Const2Parameterized(String n, int id) {         //Parameterized Constructor
		this.name = n;
		this.identity = id;
	}

	void display() {
		System.out.println(name + " " + identity);
	}

	public static void main(String[] args) {
		Const2Parameterized cp = new Const2Parameterized("Shekhu", 101);
		cp.display();

	}

}
