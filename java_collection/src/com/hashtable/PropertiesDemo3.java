package com.hashtable;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo3 {

	public static void main(String[] args) throws IOException {

		Properties p = new Properties();
		p.setProperty("name", "Deepu");
		p.setProperty("pwd", "Deepu@123");

		p.store(new FileWriter("E:\\2026_java_local_repository\\java_exception_handling\\all_files\\properties1.txt"),
				"javatpoint properties");
		System.out.println(p);

	}

}
