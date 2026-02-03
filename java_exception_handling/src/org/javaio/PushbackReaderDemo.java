package org.javaio;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.PushbackReader;

public class PushbackReaderDemo {

	public static void main(String[] args) throws IOException {
		char[] ary = { '1', '-', '-', '2', '-', '3', '4', '-', '-', '-', '5', '6' };
		CharArrayReader cout = new CharArrayReader(ary);
		PushbackReader pout = new PushbackReader(cout);

		int i;
		while ((i = pout.read()) != -1) {
			if (i == '-') {
				int j;
				if ((j = pout.read()) == '-') {
					System.out.print("#*");
				} else {
					pout.unread(j);
					System.out.print((char) i);
				}

			} else {
				System.out.print((char) i);
			}
		}
	}

}
