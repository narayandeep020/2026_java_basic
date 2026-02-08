package org.reflectionapi;

import java.lang.reflect.*;

 class Person {
	private String name = "Joye Dik";

	public void greet(String message) {
		System.out.println(name + " says: " + message);
	}
}

public class ReflectionExample {
	public static void main(String[] args) {
		try {

			Class<?> clazz = Class.forName("org.reflectionapi.Person");

			// Create an instance
			Object obj = clazz.getDeclaredConstructor().newInstance();

			// Access private field
			Field field = clazz.getDeclaredField("name");
			field.setAccessible(true);
			field.set(obj, "Alice");

			// Invoke method
			Method method = clazz.getMethod("greet", String.class);
			method.invoke(obj, "Hello via Reflection!");

			System.out.println("Class Name: " + clazz.getName());
			int i = clazz.getModifiers();
			System.out.println("Modifiers: " + Modifier.toString(i));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
