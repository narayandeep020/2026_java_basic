package org.exceptions;

import java.io.IOException;

public class PropagationExample {
	void m() throws IOException {
		throw new IOException("Device Error..");
	}

	void n() throws IOException {
		m();
	}

	void p() {
		try {
			n();
		} catch (Exception e) {
			System.out.println("Exception handled");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PropagationExample pe = new PropagationExample();
		pe.p();
		System.out.println("normal flow");
	}

}
