package com.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress2 {

	public static void main(String[] args) throws UnknownHostException {

		InetAddress ia = InetAddress.getByName("45.22.30.39");

		System.out.println("IP Address: " + ia.getHostAddress());
		System.out.println("Host Name: " + ia.getHostName());
		System.out.println("IP Address in byte: " + ia.getAddress());
		System.out.println("Is This Address Multicast: " + ia.isMulticastAddress());
		System.out.println("Address in string form: " + ia.toString());
		System.out.println("Fully qualified domain name: " + ia.getCanonicalHostName());
		System.out.println("Hashcode: " + ia.hashCode());
		System.out.println("Is the inetAddress an unpredictable address?: " + ia.isAnyLocalAddress());
	}

}
