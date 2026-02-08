package org.enumeration;

public class EnumInsideClass {
	enum Season {
		WINTER, SPRING, SUMMER, FALL
	}

	public static void main(String[] args) {
		for (Season s : Season.values()) {
			System.out.println(s);
		}
	}

}
