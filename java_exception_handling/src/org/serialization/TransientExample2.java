package org.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
public class TransientExample2 implements Serializable {
	int i = 10, j = 20;
	transient int k = 30;
	transient static int l = 40;
	transient final int m = 50;

	public static void main(String[] args) throws Exception {

		TransientExample2 te = new TransientExample2();

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.txt"));
		oos.writeObject(te);
		oos.close();

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.txt"));
		TransientExample2 te2 = (TransientExample2) ois.readObject();

		System.out.println("i = " + te2.i);
		System.out.println("j = " + te2.j);
		System.out.println("k = " + te2.k);
		System.out.println("l = " + te2.l);
		System.out.println("m = " + te2.m);
		ois.close();

	}

}
