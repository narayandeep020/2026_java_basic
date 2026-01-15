package com.oopconcepts;

class Collage {
	void clg() {
		System.out.println("In Collage");
	}
}

class Teacher extends Collage {
	void teach() {
		System.out.println("Teaching..");
	}
}

class Freshmen extends Collage {
	void study() {
		System.out.println("Learning..");
	}
}

public class InheritanceHirarchical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Freshmen fm = new Freshmen();
		fm.clg();
		fm.study();
		Teacher t = new Teacher();
		t.clg();
		t.teach();
		

	}

}
