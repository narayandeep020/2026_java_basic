package com.treemap;

import java.util.Comparator;
import java.util.TreeMap;

class Student {
	int rollno;
	String name, address;

	Student(int rollno, String name, String address) {
		this.rollno = rollno;
		this.name = name;
		this.address = address;
	}

	public String toString() {
		return this.rollno + " " + this.name + " " + this.address;
	}
}

class SortByRoll implements Comparator<Student> {

	@Override
	public int compare(Student arg1, Student arg2) {

		return arg1.rollno - arg2.rollno;
	}

}

public class TreeMapDemo2 {

	public static void main(String[] args) {

		TreeMap<Student, Integer> tm = new TreeMap<>(new SortByRoll());

		Student s1 = new Student(105, "Ajay", "Sahdol");
		Student s2 = new Student(102, "Bhavishya", "Umariya");
		Student s3 = new Student(103, "Deep", "Jabalpur");
		Student s4 = new Student(104, "Abhaye", "Narshingpur");

		tm.put(s1, 1);
		tm.put(s2, 2);
		tm.put(s3, 3);
		tm.put(s4, 4);

		System.out.println("TreeMap sorted by rollno: " + tm);

	}

}
