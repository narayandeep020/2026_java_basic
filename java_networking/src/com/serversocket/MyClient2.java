package com.serversocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class MyClient2 {
	private Socket s = null;
	private DataInputStream in = null;
	private DataOutputStream out = null;

	@SuppressWarnings("deprecation")
	public MyClient2(String addr, int port) {
		try {
			s = new Socket(addr, port);
			System.out.println("Connected.");

			in = new DataInputStream(System.in);
			out = new DataOutputStream(s.getOutputStream());
		} catch (Exception e) {
			System.out.println(e);
		}
		String m = " ";
		while (m.equals("Over")) {
			try {
				m = in.readLine();
				out.writeUTF(m);

				in.close();
				out.close();
				s.close();
			} catch (Exception i) {
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {

		new MyClient2("127.0.0.1", 5000);
	}

}
