package com.oopconcepts;

class Animal {
	void eat() {
		System.out.println("Animal is eating...");
	}

	void sleep() {
		System.out.println("Animal is sleeping...");
	}
}

class BuzoDog extends Animal {
	void bark() {
		System.out.println("Animal is barking...");
	}
}

public class InheritanceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuzoDog d = new BuzoDog();
		d.eat();
		d.sleep();
		d.bark();

	}

}
