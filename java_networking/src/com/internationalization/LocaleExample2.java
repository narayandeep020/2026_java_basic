package com.internationalization;

import java.util.Locale;

public class LocaleExample2 {

	public static void main(String[] args) {

		Locale enl = new Locale("en", "US");
		Locale frl = new Locale("fr", "FR");
		Locale esl = new Locale("es", "ES");

		System.out.println("English language name (default): " + enl.getDisplayLanguage());
		System.out.println("English language name in French: " + enl.getDisplayLanguage(frl));
		System.out.println("English language name in Spanish: " + enl.getDisplayLanguage(esl));
		Locale[] l = Locale.getAvailableLocales();
		for (Locale l2 : l) {
			System.out.println(l2.getDisplayCountry() + "......" + l2.getDisplayLanguage());
		}
	}

}
