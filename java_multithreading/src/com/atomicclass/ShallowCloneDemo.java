package com.atomicclass;

class Address {
	String city;

	Address(String city) {
		this.city = city;
	}
}

class Person implements Cloneable {
	String name;
	Address address;

	Person(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

public class ShallowCloneDemo {

	public static void main(String[] args) throws CloneNotSupportedException {

		Person p1 = new Person("Alisa", new Address("Bhopal"));
		Person p2 = (Person) p1.clone();
		p1.address.city = "Pune";
		System.out.println(p1.address.city);
		System.out.println(p2);
	}

}
