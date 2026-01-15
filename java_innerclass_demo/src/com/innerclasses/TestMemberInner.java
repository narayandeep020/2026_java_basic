package com.innerclasses;

class TestMemberInner {
	private int data = 30;

	class Inner {
		void msg() {
			System.out.println("Data is : " + data);
		}
	}

	public static void main(String[] args) {

		TestMemberInner tmi = new TestMemberInner();
		Inner in = tmi.new Inner();
		in.msg();
	}
}