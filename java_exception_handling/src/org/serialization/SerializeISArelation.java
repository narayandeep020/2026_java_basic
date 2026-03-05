package org.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
class Person implements Serializable {
	int id;
	String name;

	Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
}

@SuppressWarnings("serial")
class Employe extends Person {
	String dept;
	int salary;

	public Employe(int id, String name, String dept, int salary) {
		super(id, name);
		this.dept = dept;
		this.salary = salary;
	}
}

public class SerializeISArelation {

	public static void main(String[] args) {

		try {
			Employe e = new Employe(1023, "Deep", "Development", 30000);

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"));
			System.out.println("Employe file create success.");
			oos.writeObject(e);
			oos.close();

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"));
			Employe e2 = (Employe) ois.readObject();
			System.out.println(
					"EmpId: " + e2.id + ", EmpName: " + e2.name + ", EmpDept: " + e2.dept + ", EmpSal: " + e2.salary);
			ois.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
