package com.oopconcepts;

// Compile time polymorphism (Method Overloading)
class Helper {
	int multiply(int a, int b) {
		return a * b;
	}

	double multiply(double a, double b) {
		return a * b;
	}
}

public class PolymorphismCT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Helper h = new Helper();
		System.out.println("Multiply of integer: " + h.multiply(3, 5));
		System.out.println("Multiply of double: " + h.multiply(2.5, 3.5));
		
		// if class static 
		//then Helper.multiply direct calling

	}

}
