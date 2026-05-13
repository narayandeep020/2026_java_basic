package com.internationalization;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatDemo2 {

	static void printNumber(Locale l) {
		double d = 123456.789;
		NumberFormat nf = NumberFormat.getNumberInstance(l);
		System.out.println(l + " form is..." + nf.format(d));
	}

	public static void main(String[] args) {

		printNumber(Locale.UK);
		printNumber(Locale.US);
		printNumber(Locale.FRANCE);
		printNumber(Locale.JAPAN);

	}

}
