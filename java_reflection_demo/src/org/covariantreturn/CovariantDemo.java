package org.covariantreturn;

class Aim {
	Aim get() {
		return this;
	}
}

public class CovariantDemo extends Aim {
	CovariantDemo get() {
		return this;
	}

	void msg() {
		System.out.println("Welcome to covariant return type.");
	}

	public static void main(String[] args) {
		new CovariantDemo().get().msg();
	}

}
