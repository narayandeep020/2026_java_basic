package com.oopconcepts;

import java.util.ArrayList;
import java.util.List;

class Mobile {
	private String mobile_no;

	public String getMobileNo() {
		return mobile_no;
	}

	public void setMobileNo(String mobile_no) {
		this.mobile_no = mobile_no;
	}
}

class Person {
	private String name;
	List<Mobile> numbers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Mobile> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Mobile> numbers) {
		this.numbers = numbers;
	}
}

public class AssociationDemo {

	public static void main(String[] args) {
		Person p = new Person();
		p.setName("Subh Raj");
		

		Mobile m1 = new Mobile();
		m1.setMobileNo("8839422237");
		Mobile m2 = new Mobile();
		m2.setMobileNo("1234567890");

		List<Mobile> nl = new ArrayList<Mobile>();
		nl.add(m1);
		nl.add(m2);
		p.setNumbers(nl);
		System.out.println(p.getNumbers() + "are mobile no of person " + p.getName());

	}

}
