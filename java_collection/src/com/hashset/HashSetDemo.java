package com.hashset;

import java.util.HashSet;
import java.util.Iterator;

class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Person p = (Person) o;
		return age == p.age && name.equals(p.name);
	}

	public int hashCode() {
		return name.hashCode() + age;
	}

	public String toString() {
		return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
	}
}

public class HashSetDemo {

	public static void main(String[] args) {

		HashSet<String> set = new HashSet<>();
		set.add("Apple");
		set.add("Banana");
		set.add("Mango");
		System.out.println("HashSet is: " + set);

		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("===============");

		String[] arr = set.toArray(new String[0]);
		System.out.println("HashSet convert to array: ");
		for (String str : arr) {
			System.out.println(str);
		}
		System.out.println("==============");

		HashSet<Person> hp = new HashSet<>();
		hp.add(new Person("Akki", 23));
		hp.add(new Person("Bakki", 30));

		System.out.println("HashSet of custom object: " + hp);
	}

}
