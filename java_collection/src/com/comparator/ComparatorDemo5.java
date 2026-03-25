package com.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Candidate {
	String name;
	Integer age;

	Candidate(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public String toString() {
		return name + "   " + age;
	}
}

class StudentComparator implements Comparator<Candidate> {

	@Override
	public int compare(Candidate s1, Candidate s2) {
		int nameCompare = s1.getName().compareTo(s2.getName());
		int ageCompare = s1.getAge().compareTo(s2.getAge());
		return (nameCompare == 0) ? ageCompare : nameCompare;
	}

}

public class ComparatorDemo5 {

	public static void main(String[] args) {

		ArrayList<Candidate> std = new ArrayList<>();
		std.add(new Candidate("Satyam", 18));
		std.add(new Candidate("Shivam", 27));
		std.add(new Candidate("Deep", 24));

		Collections.sort(std, new StudentComparator());

		System.out.println("After Sorting:");
		for (Candidate c : std) {
			System.out.println(c);
		}
	}

}
