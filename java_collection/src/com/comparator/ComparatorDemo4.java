package com.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student implements Comparable<Student> {
	int rollno;
	String name;
	int age;

	Student(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

class AgeComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		if (s1.age == s2.age)
			return 0;
		else if (s1.age > s2.age)
			return 1;
		else
			return -1;
	}

}

class NameComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		return s1.name.compareTo(s2.name);
	}
}

public class ComparatorDemo4 {

	public static void main(String[] args) {

		ArrayList<Student> al = new ArrayList<>();

		al.add(new Student(101, "Chiru", 23));
		al.add(new Student(102, "Naga", 20));
		al.add(new Student(103, "Amaan", 27));

		System.out.println("Sorting by Age:");

		Collections.sort(al, new AgeComparator());
		for (Student st : al) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);

		}
		System.out.println("=================");
		System.out.println("Sorting by Name:");

		Collections.sort(al, new NameComparator());
		for (Student st : al) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}
	}

}
