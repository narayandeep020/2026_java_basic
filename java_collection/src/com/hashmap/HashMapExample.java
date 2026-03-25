package com.hashmap;

import java.util.HashMap;
import java.util.Map;

class Book {
	int idno;
	String name;
	int published;

	Book(int idno, String name, int published) {
		this.idno = idno;
		this.name = name;
		this.published = published;
	}
}

public class HashMapExample {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		HashMap<Integer, Book> m = new HashMap<>();

		Book b1 = new Book(101, "Java Programming", 1995);
		Book b2 = new Book(103, "Data Structure", 2010);
		Book b3 = new Book(105, "Data Base", 2003);

		m.put(1, b1);
		m.put(2, b2);
		m.put(3, b3);

		for (Map.Entry<Integer, Book> entry : m.entrySet()) {
			int k = entry.getKey();
			Book b = entry.getValue();
			System.out.println(k + " Details:");
			System.out.println(b.idno + ":" + b.name + ":" + b.published);
		}
	}

}
