package com.oopconcepts;

class Address {
	String city, state, country;

	public Address(String city, String state, String country) {
		this.city = city;
		this.country = country;
		this.state = state;
	}
}

class Emp {
	int id;
	String name;
	Address addr; // Emp HAS-A Address

	public Emp(int id, String name, Address addr) {
		this.id = id;
		this.name = name;
		this.addr = addr;
	}

	void disp() {
		System.out.println(id + " " + name);
		System.out.println(addr.city + " " + addr.state + " " + addr.country);
	}
}

public class AggregationDemo {

	public static void main(String[] args) {
		Address addr1 = new Address("katni", "MP", "India");
		Address addr2 = new Address("Pune", "MH", "India");

		Emp e1 = new Emp(101, "Deva", addr1);
		Emp e2 = new Emp(102, "singh", addr2);

		e1.disp();
		e2.disp();

	}

}
