package org.filehandling;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			double d = 1.5;
			float f = 14.56f;

			RandomAccessFile raf = new RandomAccessFile("raf.txt", "rw");
			raf.writeUTF("Hello to java program");
			raf.seek(0);
			System.out.println("Use of read(): " + raf.read());
			raf.seek(0);

			@SuppressWarnings("unused")
			byte[] b = { 1, 2, 3 };
			System.out.println("Use of read(byte[] b): " + raf.read(b));
			System.out.println("Use of readBoolean: " + raf.readBoolean());
			System.out.println("Use of readByte: " + raf.readByte());
			
			raf.writeChar('D');
			raf.seek(0);
			System.out.println("Use of readChar: " + raf.readChar());

			raf.seek(0);
			raf.writeDouble(d);
			raf.seek(0);
			System.out.println("Use of readDouble: " + raf.readDouble());

			raf.seek(0);
			raf.writeFloat(f);
			raf.seek(0);
			System.out.println("Use of readFloat: " + raf.readFloat());

//			byte[] arr = new byte[(int) raf.length()];
//			System.out.println(raf.length());
//			
//			raf.readFully(arr);
//
//			String str1 = new String(arr);
//			System.out.println("Use of readFully: " + str1);
//			raf.seek(0);
//
//			raf.readFully(arr, 0, 8);
//			String str2 = new String(arr);
//			System.out.println("Use of readFully(byte[] b, int off,int len: )" + str2);
			
		} catch (IOException e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
	}

}
