package com.instanceblock;
//Instance Initializer Block with Multiple Constructors

class A {
	A() {
		System.out.println("Parent class constructor invoked");
	}
}

class IBExample3 extends A {
	IBExample3() {
		super();
		System.out.println("Child class constructor invoked");
	}

	IBExample3(int a) {
		super();
		System.out.println("Child class constructor: " + a);
	}

	{
		System.out.println("Instance initilizer block invoked");
	}

	public static void main(String[] args) {
		new IBExample3();
		new IBExample3(10);
	}

}
