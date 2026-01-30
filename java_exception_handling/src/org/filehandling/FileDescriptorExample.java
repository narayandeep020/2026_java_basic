package org.filehandling;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileDescriptorExample {

	public static void main(String[] args) {
		FileDescriptor fd = null;
		byte[] b = {48,49,50,51,52,53,54,55,56,57,58};
		
		try {
			FileOutputStream fos = new FileOutputStream("descript.txt");
			FileInputStream fis = new FileInputStream("descript.txt");
			
			fd = fos.getFD();
			fos.write(b);
			fos.flush();
			fd.sync();
			
			int value = 0;
			while((value = fis.read()) != -1) {
				char c = (char)value;
				System.out.print(c);
			}
			System.out.println("\nSync() Successfully Executed!!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
