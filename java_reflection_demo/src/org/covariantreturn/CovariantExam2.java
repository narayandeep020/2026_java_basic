package org.covariantreturn;

class Aimi {
	Object print() {
		System.out.println("print method of class A");
		return new Object();
	}
}

public class CovariantExam2 extends Aimi {
	Integer print() {
		System.out.println("print method of class B");
		return new Integer(2);
	}

	public static void main(String[] args) {
		CovariantExam2 ce = new CovariantExam2();
		ce.print();

		Aimi a = new CovariantExam2();
		a.print();
	}

}
