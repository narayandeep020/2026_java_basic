package org.covariantreturn;

interface Printable {
}

class A implements Printable {
	public void a() {
		System.out.println("method a");
	}
}

class B implements Printable {
	public void b() {
		System.out.println("method b");
	}
}

class Call {
	void invoke(Printable p) {
		if (p instanceof A) {
			A a = (A) p;
			a.a();
		}
		if (p instanceof B) {
			B b = (B) p;
			b.b();
		}
	}
}

public class InstanceOfDemo {

	public static void main(String[] args) {
		Printable p = new A();
		Call c = new Call();
		c.invoke(p);
	}

}
