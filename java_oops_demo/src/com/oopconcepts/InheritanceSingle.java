package com.oopconcepts;

class Vehical {
	void vehical() {
		System.out.println("This is Vehicle.");
	}
}

class Cargo extends Vehical {
	void car() {
		System.out.println("This is Car.");
	}
}

public class InheritanceSingle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cargo c = new Cargo();
		c.car();
		c.vehical();
	}

}
