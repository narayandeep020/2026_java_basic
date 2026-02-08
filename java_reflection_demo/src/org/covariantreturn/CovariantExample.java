package org.covariantreturn;

class A1 {
	A1 fom() {
		return this;
	}

	void print() {
		System.out.println("Inside the class A1");
	}
}

class A2 extends A1 {
	@Override
	A2 fom() {
		return this;
	}

	void print() {
		System.out.println("Inside the class A2");
	}
}

class A3 extends A2 {
	@Override
	A3 fom() {
		return this;
	}

	@Override
	void print() {
		System.out.println("Inside the class A3");
	}
}

public class CovariantExample {

	public static void main(String[] args) {
		A1 a1 = new A1();
		a1.fom().print();
		
		A2 a2 = new A2();
		a2.fom().print();

		A3 a3 = new A3();
		a3.fom().print();
	}

}
