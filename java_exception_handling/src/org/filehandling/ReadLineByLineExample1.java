package org.filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadLineByLineExample1 {

	public static void main(String[] args) {
		try {
			File file = new File("example.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			StringBuffer sb = new StringBuffer();
			String line ;
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			fr.close();
			System.out.println("Content of file: ");
			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
