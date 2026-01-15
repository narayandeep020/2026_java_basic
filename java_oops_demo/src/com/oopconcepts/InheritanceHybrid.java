package com.oopconcepts;

class C {
	void disp1() {
		System.out.println("C");
	}
}

class A extends C {
	void disp2() {
		System.out.println("A");
	}
}

class B extends C { // Not calling by D object 
	void disp3() {
		System.out.println("B");
	}
}

class D extends A {
	void disp4() {
		System.out.println("D");
	}
}

public class InheritanceHybrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		D obj = new D();
		obj.disp2();
		obj.disp1();
		obj.disp4();
	}

}
