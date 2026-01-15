package com.innerclasses;

public class StaticNested { 
	static int data = 30;

	static class Inner {
		void msg() {		// Using instance method
			System.out.println("Data is " + data);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticNested.Inner sni = new StaticNested.Inner();
		sni.msg();
	}
}

// Using static method

//static class Inner{
//	static void msg() {
//		System.out.println("Data is "+ data);
//	}
//}
//	//Call
//StaticNested.Inner.mgs();