package com.internationalization;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo {

	public static void main(String[] args) {

		ResourceBundle rb = ResourceBundle.getBundle("MessageBundle", Locale.US);
		System.out.println("Message in "+Locale.US+":"+rb.getString("Greeting"));
		
		Locale.setDefault(new Locale("in", "ID"));
		rb = ResourceBundle.getBundle("MessageBundle");
		System.out.println("Message in " + Locale.getDefault() + ":" + rb.getString("Greeting"));

	}

}
