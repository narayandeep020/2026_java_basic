package com.oopconcepts;

abstract class Vehicle {
	// Abstract method
	abstract void accelerate();

	abstract void brake();


// Concrete method
	void engineStart() {
		System.out.println("Car: Engine started !");
	}
}

// Implementation concrete
class Car extends Vehicle {
	@Override
	void accelerate() {
		System.out.println("Car: Pressing accelerate....");
	}

	@Override
	void brake() {
		System.out.println("Car: Applying brake....");
		System.out.println("Car: Stoped....!");

	}
}

public class AbstrctionExample {

	public static void main(String[] args) {
		Vehicle myCar = new Car();
		myCar.engineStart();
		myCar.accelerate();
		myCar.brake();

	}

}
