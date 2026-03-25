package com.treeset;

import java.util.TreeSet;

class Student implements Comparable<Student> {
	int rollno;
	String name;
	int age;

	Student(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}

	public int compareTo(Student st) {
		if (age == st.age)
			return 0;
		else if (age > st.age)
			return 1;
		else
			return -1;
	}
}

public class ComparableDemo {

	public static void main(String[] args) {

		TreeSet<Student> ts = new TreeSet<>();
		ts.add(new Student(101, "Rahul", 26));
		ts.add(new Student(102, "Amit", 25));
		ts.add(new Student(103, "Deep", 24));

		for (Student s : ts) {
			System.out.println(s.rollno + " " + s.name + " " + s.age);
		}
//		Collections.sort(ts);
//		for (Student s : ts) {
//			System.out.println(s.rollno + " " + s.name + " " + s.age);
//		}

	}

}
