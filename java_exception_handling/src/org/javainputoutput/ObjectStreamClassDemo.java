package org.javainputoutput;

import java.io.ObjectStreamClass;
import java.io.Serializable;

public class ObjectStreamClassDemo {
	public static void main(String[] args) {
		ObjectStreamClass desc = ObjectStreamClass.lookup(Employee.class);
		if (desc != null) {
//			System.out.println("name: " + desc.getField("name"));
			System.out.println("Class from ObjectStreamClass: " + desc.forClass().getName());
		} else {
			System.out.println("Class not serializable.");
		}
	}

	static class Employee implements Serializable {
		private static final long serialVersionUID = 1L;
		String name = "Something";
		int id;
	}
}