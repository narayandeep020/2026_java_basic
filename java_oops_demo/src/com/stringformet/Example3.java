package com.stringformet;

import java.util.Locale;

public class Example3 {

	public static void main(String[] args) {
		double salary = 123456.78;

		String us = String.format(Locale.US, "Salary: $%,.2f", salary);
		String ge = String.format(Locale.GERMANY, "Gehalt: %,.2f", salary);
		String fr = String.format(Locale.FRANCE, "Salaire: %,.2f", salary);

		System.out.println(us);
		System.out.println(ge);
		System.out.println(fr);

	}

}
