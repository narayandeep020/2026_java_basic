package org.javainputoutput;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputStreamExample {

	public static void main(String[] args) throws Exception {
		FileOutputStream fis = new FileOutputStream("demo1.txt");
		DataOutputStream dos = new DataOutputStream(fis);

		dos.writeInt(66); // B
//		dos.writeBoolean(true);
		dos.flush();
		dos.close();

		System.out.println("Success....");
	}

}
