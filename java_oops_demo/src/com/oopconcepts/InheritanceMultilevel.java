package com.oopconcepts;

class Aniimal {
	void eat() {
		System.out.println("Eating....");
	}
}

class Dogi extends Aniimal {
	void bark() {
		System.out.println("Barking....");
	}
}

class BabyDog extends Dogi {
	void weep() {
		System.out.println("Weeping....");
	}
}

public class InheritanceMultilevel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BabyDog bd = new BabyDog();
		bd.eat();
		bd.bark();
		bd.weep();
	}

}
