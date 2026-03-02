package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataExtracting {

	public static void main(String[] args) {

		System.out.println("Example1: Extracting phone number from text.");

		String text1 = "Please call 123-456-7890 for assistance or 987-654-3210 for inquiries";
		String phonrRegex1 = "\\b\\d{3}-\\d{3}-\\d{4}\\b";
		Pattern pp1 = Pattern.compile(phonrRegex1);
		Matcher pm1 = pp1.matcher(text1);
		System.out.println("Phone number found in the text: ");
		while (pm1.find()) {
			System.out.println(pm1.group() + " ");
		}
		System.out.println("================");

		System.out.println("Example2: Extracting URLs from text.");

		String text2 = "Visit our website at https://www.example.com or http//www.another.example.ogr";
		String urlRegex2 = "\\bhttps?://\\S+\\b";
		Pattern urlP2 = Pattern.compile(urlRegex2);
		Matcher urlM2 = urlP2.matcher(text2);
		System.out.println("URLs found in the text: ");
		while (urlM2.find()) {
			System.out.println(urlM2.group() + " ");
		}
		System.out.println("=================");

		System.out.println("Example3: Matching email addresses in text.");

		String text3 = "Contact us at email@example.com or another.email@example.org";
		String emailRegex3 = "\\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9._]+\\.[a-zA-Z]{2,}\\b";
		Pattern emailP3 = Pattern.compile(emailRegex3);
		Matcher emailM3 = emailP3.matcher(text3);
		System.out.println("Email found in the text: ");
		while (emailM3.find()) {
			System.out.println(emailM3.group() + " ");
		}

	}

}
