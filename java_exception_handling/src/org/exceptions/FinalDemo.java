package org.exceptions;

public class FinalDemo {
//	final int age = 18;
	int age = 18;

	void display() {
		age = 55;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinalDemo fd = new FinalDemo();
		fd.display();
	}

}
