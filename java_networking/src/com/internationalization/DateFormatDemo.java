package com.internationalization;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatDemo {

	public static void main(String[] args) {

		System.out.println("Full form: " + DateFormat.getDateInstance(0, Locale.US).format(new Date()));
		System.out.println("Long Form: " + DateFormat.getDateInstance(1, Locale.US).format(new Date()));
		System.out.println("Medium Form: " + DateFormat.getDateInstance(2, Locale.US).format(new Date()));
		System.out.println("Short form: " + DateFormat.getDateInstance().format(new Date()));

		System.out.println("\nFull form of uk: " + DateFormat.getDateInstance(0, Locale.UK).format(new Date()));
		System.out.println("Full form of german: " + DateFormat.getDateInstance(0, Locale.GERMAN).format(new Date()));
		System.out.println("Full form of italy: " + DateFormat.getDateInstance(0, Locale.ITALY).format(new Date()));
		
		System.out.println("Full form: " + DateFormat.getDateTimeInstance(0,0,Locale.getDefault()).format(new Date()));


	}

}
