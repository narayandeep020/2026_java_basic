package org.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String name;

	Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
}

public class Example {

	public static void main(String[] args) throws Exception {

		Student s1 = new Student(101, "Deep");

		// serialization
		FileOutputStream fos = new FileOutputStream("student.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s1);
		oos.close();
		fos.close();

		// deserialization
		FileInputStream fis = new FileInputStream("student.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student s2 = (Student) ois.readObject();
		ois.close();
		fis.close();

		System.out.println("ID: " + s2.id + ", Name: " + s2.name);
	}

}
