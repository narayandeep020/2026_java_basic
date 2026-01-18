package com.instanceblock;

public class InstanceBlockDemo {
	int speed;

	InstanceBlockDemo() {
		System.out.println("Speed is: " + speed);
	}

	{
		speed = 100;
	}

	public static void main(String[] args) {
		new InstanceBlockDemo();
		new InstanceBlockDemo();

	}

}
