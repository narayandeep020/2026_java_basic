package org.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
class User implements Serializable {
	String userName;
	transient String password;

	User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
}

public class TransientExample {

	public static void main(String[] args) throws Exception {

		User u1 = new User("Deep", "secret123");

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.txt"));
		oos.writeObject(u1);
		oos.close();

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.txt"));
		User u2 = (User) ois.readObject();
		ois.close();

		System.out.println("Username: " + u2.userName);
		System.out.println("UserPassword: " + u2.password);
	}

}
