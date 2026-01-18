package com.stringformet;

public class Example5 {

	public static void main(String[] args) {
		double d = 1500.75;

		String s = "kilometers";

		 String res = String.format("%1$,7.1f %2$s", d, s);
		System.out.println(res);
	}

}
