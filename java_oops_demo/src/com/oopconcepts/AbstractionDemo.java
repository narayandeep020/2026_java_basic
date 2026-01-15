package com.oopconcepts;

public class AbstractionDemo {

	public static void main(String[] args) {
		Cat c = new Cat();
		c.eat();
	}

}

abstract class AnimalTest {
	abstract void eat();
}

class Cat extends AnimalTest {

	@Override
	void eat() {
		System.out.println("Eating Milk....!");
	}

}