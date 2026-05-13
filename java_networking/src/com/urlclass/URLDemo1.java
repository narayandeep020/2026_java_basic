package com.urlclass;

import java.net.URL;

public class URLDemo1 {

	public static void main(String[] args) {

		try {
			URL url = new URL("http://www.javatpoint.com/java-tutorial");

			System.out.println("Protocol: " + url.getProtocol());
			System.out.println("Host Name: " + url.getHost());
			System.out.println("Port Number: " + url.getPort());
			System.out.println("Default Port Number: "+url.getDefaultPort());
			System.out.println("File Name: " + url.getFile());
			System.out.println("Reference: "+url.getRef());

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
