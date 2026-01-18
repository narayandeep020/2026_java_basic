package com.instanceblock;

public class IBWithStaticDemo {
	IBWithStaticDemo(int x) {
		System.out.println("first constructor with args: "+x);
	}

	IBWithStaticDemo() {
		System.out.println("second constructor with no args");
	}

	static {
		System.out.println("first static bolck");
	}
	{
		System.out.println("first instance block");
	}
	{
		System.out.println("second instance block");
	}
	static {
		System.out.println("second static block");
	}

	public static void main(String[] args) {
		new IBWithStaticDemo();
		new IBWithStaticDemo(7);
	}

}
