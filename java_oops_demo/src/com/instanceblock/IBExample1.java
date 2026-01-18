package com.instanceblock;

public class IBExample1 {
	int speed;

	IBExample1() {
		System.out.println("Constructor is invoked");
	}

	{
		System.out.println("Instance initilizer is invoked.");
	}

	public static void main(String[] args) {
		new IBExample1();
		new IBExample1();
	}

}
