package com.internationalization;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatCurrency {

	static void printCurrency(Locale l) {
		double d = 123456.789;
		NumberFormat nf = NumberFormat.getCurrencyInstance(l);
		System.out.println(l + " form is...." + nf.format(d));
	}

	public static void main(String[] args) {

		printCurrency(Locale.US);
		printCurrency(Locale.CHINA);
		printCurrency(Locale.getDefault());
	}

}
