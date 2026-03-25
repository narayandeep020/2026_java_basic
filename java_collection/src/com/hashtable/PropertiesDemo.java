package com.hashtable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) throws Exception {

		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(
				"E:\\2026_java_local_repository\\java_exception_handling\\all_files\\properties.txt");
		p.load(fis);
		System.out.println(p);

		String s = p.getProperty("venki");
		System.out.println(s);

		p.setProperty("nag", "888888");
		FileOutputStream fos = new FileOutputStream(
				"E:\\2026_java_local_repository\\java_exception_handling\\all_files\\properties.txt");
		p.store(fos, "Update by Durga sir");

	}

}
