package com.inetaddress;

import java.net.InetAddress;

public class InetAddressDemo {

	public static void main(String[] args) {

		try {
			InetAddress ia = InetAddress.getByName("www.google.com");

			System.out.println("Host Name: " + ia.getHostName());
			System.out.println("IP Address: " + ia.getHostAddress());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
