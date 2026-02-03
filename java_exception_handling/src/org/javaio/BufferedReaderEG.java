package org.javaio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderEG {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String name = "";
		while (!name.equals("Stop")) {
			System.out.println("Enter data: ");
			name = br.readLine();
			System.out.println("Data is: " + name);
		}
		br.close();
		isr.close();
	}

}
