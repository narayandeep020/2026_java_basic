package com.instanceblock;

class IB {
	IB() {
		System.out.println("parent class constructor invoked");
	}
}

public class IBExample20 extends IB {
	IBExample20() {
		super();
		System.out.println("child class constructor invoked");
	}

	{
		System.out.println("instance initializer block is invoked");
	}

	public static void main(String[] args) {
		 new IBExample20();
	}
}
