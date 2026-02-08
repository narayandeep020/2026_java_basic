package org.enumeration;

enum Days {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class EnumDemo {

	public static void main(String[] args) {
		Days today = Days.SATURDAY; // Access single value
		System.out.println("Today is: " + today);

		System.out.println("All days of the week:");
		for (Days d : Days.values()) {   // Access all values
			System.out.println(d);
		}

	}

}
