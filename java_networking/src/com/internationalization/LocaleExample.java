package com.internationalization;

import java.util.Locale;

public class LocaleExample {

	public static void main(String[] args) {

		Locale l = Locale.getDefault();

		System.out.println(l.getDisplayCountry());
		System.out.println(l.getDisplayLanguage());
		System.out.println(l.getDisplayName());
		System.out.println(l.getISO3Country());
		System.out.println(l.getISO3Language());
		System.out.println(l.getCountry());
		System.out.println(l.getLanguage());

	}

}
