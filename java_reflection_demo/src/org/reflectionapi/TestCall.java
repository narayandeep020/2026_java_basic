package org.reflectionapi;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestCall {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Test t = new Test();
		Class<?> c = t.getClass();
		Field[] flsd = c.getDeclaredFields();
		for (Field f : flsd) {
			System.out.println("Name: " + f.getName());
			System.out.println("Data Type: " + f.getType().getName());
			int i = f.getModifiers();
			System.out.println("Modifiers: " + Modifier.toString(i));
			System.out.println("Value: " + f.get(f));
			
			System.out.println("-------------------------------");
		}
	}

}
