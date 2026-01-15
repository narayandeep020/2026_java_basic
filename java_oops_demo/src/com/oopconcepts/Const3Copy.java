package com.oopconcepts;

public class Const3Copy {

	String name;
	int id;

	Const3Copy(String n, int id) { // Constructor
		this.name = n;
		this.id = id;
	}

	Const3Copy(Const3Copy cc) { // Copy Constructor
		name = cc.name;
		id = cc.id;
	}

	void display() {
		System.out.println(name + ": " + id);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Constructor");
		Const3Copy cc1 = new Const3Copy("Dealer", 1023);
		cc1.display();

		System.out.println("Copy Constructor");
		Const3Copy cc2 = new Const3Copy("Reciver", 1025);
		cc2.display();
	}

}
