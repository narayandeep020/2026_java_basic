package com.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

class Student {
	int rollno;
	String name;
	int age;

	Student(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}
}

public class ArrayListUserDefine {

	public static void main(String[] args) {

		Student s1 = new Student(101, "Maha", 23);
		Student s2 = new Student(102, "Deva", 21);
		Student s3 = new Student(103, "Namah", 25);

		ArrayList<Student> as = new ArrayList<Student>();
		as.add(s1);
		as.add(s2);
		as.add(s3);

		Iterator<Student> tr = as.iterator();
		while (tr.hasNext()) {
			Student st = tr.next();
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}
	}

}
