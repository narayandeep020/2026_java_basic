package com.stringformet;

public class Example4 {

	public static void main(String[] args) {
		String name = "Alisa";
		String city = "London";
		String template = """	
				Hello %s!
				Welcome to %s
				We hope you injoy your stay.""".formatted(name, city);

		System.out.println(template);

	}

}
