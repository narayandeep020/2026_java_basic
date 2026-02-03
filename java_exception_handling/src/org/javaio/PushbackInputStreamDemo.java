package org.javaio;

import java.io.ByteArrayInputStream;
import java.io.PrintWriter;
import java.io.PushbackInputStream;

public class PushbackInputStreamDemo {

	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(System.out, true);
		String str = "geeks a Computer Science Portal";
		byte b[] = str.getBytes();

		ByteArrayInputStream bout = new ByteArrayInputStream(b);
		PushbackInputStream push = new PushbackInputStream(bout);

		int c;
		while ((c = push.read()) != -1) {
			pw.print((char) c);
		}
		pw.println();

		push.read(b, 0, 6);

		for (int i = 0; i < 16; i++) {
			pw.print((char) b[i]);
		}
		pw.println();
		pw.close();
	}

}
