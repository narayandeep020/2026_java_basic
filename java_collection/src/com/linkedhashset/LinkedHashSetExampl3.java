package com.linkedhashset;

import java.util.LinkedHashSet;

class Book {
	int id;
	String name, author;

	public Book(int id, String name, String author) {
		this.id = id;
		this.name = name;
		this.author = author;
	}
}

public class LinkedHashSetExampl3 {

	public static void main(String[] args) {

		LinkedHashSet<Book> sb = new LinkedHashSet<>();

		Book b1 = new Book(101, "Let us C", "Yashwant Kanetkar");
		Book b2 = new Book(102, "Operating System", "Galvin");
		Book b3 = new Book(103, "As a Man Thinketh", "Jems Alen");

		sb.add(b1);
		sb.add(b2);
		sb.add(b3);

		for (Book b : sb) {
			System.out.println(b.id + "/ " + b.name + "... " + b.author);
		}

	}

}
