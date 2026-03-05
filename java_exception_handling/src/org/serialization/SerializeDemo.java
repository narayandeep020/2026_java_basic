package org.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int bookId;
	String bookName;

	Book(int bookId, String bookName) {
		this.bookId = bookId;
		this.bookName = bookName;
	}
}

public class SerializeDemo {

	public static void main(String[] args) {

		try {
			Book b = new Book(1001, "Computer Science");

			FileOutputStream fos = new FileOutputStream("book.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(b);
			oos.flush();
			oos.close();
			fos.close();
			System.out.println("File create success.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
