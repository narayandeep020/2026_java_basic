package org.reflectionapi;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class EmployeeCall {

	public static void main(String[] args) throws Exception {
		Class<Employee> cl = Employee.class;

		@SuppressWarnings("rawtypes")
		Constructor[] con = cl.getDeclaredConstructors();
		for (Constructor<?> c : con) {
			System.out.println("Name: " + c.getName());
			int i = c.getModifiers();
			System.out.println("Modifiers: " + Modifier.toString(i));

			System.out.println("Parameter Type: ");
			@SuppressWarnings("rawtypes")
			Class[] cl1 = c.getParameterTypes();
			for (Class<?> c1 : cl1) {
				System.out.println(c1.getName() + " ");
			}

			System.out.println();

			@SuppressWarnings("rawtypes")
			Class[] cl2 = c.getExceptionTypes();
			System.out.println("Exception Types: ");
			for (Class<?> c2 : cl2) {
				System.out.println(c2.getName() + " ");
			}
			System.out.println();
			System.out.println("-------------------------");
		}

	}

}
