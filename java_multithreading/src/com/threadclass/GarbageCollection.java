package com.threadclass;

class Student {
	int rollNo;
	String name;

	Student(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}

	protected void finalize() {
		System.out.println("Student object is garbage collected.");
	}
}

public class GarbageCollection {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Student s1 = new Student(101, "Keemon");
		Student s2 = new Student(102, "pokeemon");

		s1 = null;
		s2 = null;

		System.gc();

	}

}
