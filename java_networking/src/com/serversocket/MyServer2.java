package com.serversocket;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer2 {
	private Socket s = null;
	private ServerSocket ss = null;
	private DataInputStream in = null;

	public MyServer2(int port) {
		try {
			ss = new ServerSocket(port);
			System.out.println("server started");
			System.out.println("waitnig for a client");

			s = ss.accept();
			System.out.println("client accepted");

			in = new DataInputStream(new BufferedInputStream(s.getInputStream()));

			String m = " ";
			while (m.equals("Over")) {
				try {
					m = in.readUTF();
					System.out.println(m);
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			System.out.println("closing connection.....");
			s.close();
			in.close();
		} catch (IOException i) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {

		new MyServer2(5000);
	}

}
