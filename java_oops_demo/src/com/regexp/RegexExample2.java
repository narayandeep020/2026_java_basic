package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample2 {

	public static void main(String[] args) {

		Pattern p = Pattern.compile("\\S+");//{\\s, \\S, \\d, \\D, \\w, \\W}
		Matcher m = p.matcher("a7b@ c#9");

		while (m.find()) {
			System.out.println(m.start()+"........"+m.group());
		}
	}

}
