package com.oopconcepts;

// Runtime polymorphism (Method Overriding)
class Super {
	void print() {
		System.out.println("Parent class.");
	}
}

class subclass1 extends Super {
	void print() {
		System.out.println("Subclass1.");
	}
}

class subclass2 extends Super {
	void print() {
		System.out.println("Subclass2.");
	}
}

public class PolymorphismRT {

	public static void main(String[] args) {
		Super p;
		p = new subclass1();
		p.print();
		p = new subclass2();
		p.print();

	}

}
