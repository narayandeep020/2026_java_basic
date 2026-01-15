package com.oopconcepts;

import java.util.ArrayList;
import java.util.List;

class Collage1 {
	public String name;
	public String address;

	Collage1(String name, String address) {
		this.name = name;
		this.address = address;
	}
}

class University {
	private List<Collage1>collages;

	 public University(List<Collage1> collages) {
		this.collages = collages;
	}

	public List<Collage1> getTotalCollageInUniversity() {
		return collages;
	}
}

public class CompositionDemo {

	public static void main(String[] args) {
		Collage1 c1 = new Collage1("TIET ", "Jabalpur");
		Collage1 c2 = new Collage1("Trinity ", "Bhopal");
		Collage1 c3 = new Collage1("IIM&T ", "Pune");

		List<Collage1> clgs = new ArrayList<Collage1>();
		clgs.add(c1);
		clgs.add(c2);
		clgs.add(c3);

		University uni = new University(clgs);
		List<Collage1> collages = uni.getTotalCollageInUniversity();
		for (Collage1 cg : collages) {
			System.out.println("Name: " + cg.name + "And" + "Address: " + cg.address);
		}

	}

}
