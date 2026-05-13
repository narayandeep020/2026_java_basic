package com.internationalization;

import java.util.Locale;

public class LocaleEx {

	public static void main(String[] args) {

		Locale[] l = { new Locale("en", "US"), new Locale("es", "ES"), new Locale("it", "IT") };

		for (int i = 0; i < l.length; i++) {
			String dis = l[i].getDisplayLanguage(l[i]);
			System.out.println(l[i].toString() + ":" + dis);
		}
	}

}
