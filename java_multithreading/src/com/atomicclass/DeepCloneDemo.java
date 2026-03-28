package com.atomicclass;

class Test {
	int x, y;
}

class Test2 implements Cloneable {
	int a, b;

	Test t1 = new Test();

	public Object clone() throws CloneNotSupportedException {
		Test2 t2 = (Test2) super.clone();

		t2.t1 = new Test();
		t2.t1.x = t1.x;
		t2.t1.y = t1.y;
		return t2;
	}
}

public class DeepCloneDemo {

	public static void main(String[] args) throws CloneNotSupportedException {

		Test2 t = new Test2();
		t.a = 10;
		t.b = 20;
		t.t1.x = 30;
		t.t1.y = 40;

		Test2 t3 = (Test2) t.clone();
		t3.a = 100;
		t3.t1.x = 300;

		System.out.println(t.a + " " + t.b + " " + t.t1.x + " " + t.t1.y);
		System.out.println(t3.a + " " + t3.b + " " + t3.t1.x + " " + t3.t1.y);
	}

}
