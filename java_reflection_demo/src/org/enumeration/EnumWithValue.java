package org.enumeration;

public class EnumWithValue {
	enum Season {
		WINTER(5), SUMMER(10), SPRING(15), FALL(20);

		private int value;

		private Season(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		for (Season s : Season.values())

			System.out.println(s+" "+s.value);
	}

}
