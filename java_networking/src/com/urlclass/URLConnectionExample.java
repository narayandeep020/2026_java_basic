package com.urlclass;

import java.net.URL;
import java.net.URLConnection;

import org.omg.CORBA.portable.InputStream;

public class URLConnectionExample {

	public static void main(String[] args) {

		try {
			URL url = new URL("www.javatpoint.com/java-tutorial");
			URLConnection uc = url.openConnection();
			InputStream is = (InputStream) uc.getInputStream();
			int i;
			while ((i = is.read()) != -1) {
				System.out.println((char) i);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
