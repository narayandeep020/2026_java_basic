package org.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeDemo {

	public static void main(String[] args) {

		try {
			FileInputStream fis = new FileInputStream("book.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			Book b2 = (Book) ois.readObject();

			System.out.println("BookId: " + b2.bookId + ", BookName: " + b2.bookName);
			ois.close();
			fis.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
