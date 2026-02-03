package com.stringformet;

public class StringToPrimitiveConversion {

	public static void main(String[] args) {
		String intStr = "125";
		String floatStr = "125.25";
		String boolStr = "true";

		try {
			int intNum = Integer.parseInt(intStr);
			System.out.println("Convert int value: " + intNum);

			long longNum = Long.parseLong(intStr);
			System.out.println("Convert long value: " + longNum);

			float floatNum = Float.parseFloat(floatStr);
			System.out.println("Convert float value: " + floatNum);

			double doubleNum = Double.parseDouble(floatStr);
			System.out.println("Convert double value: " + doubleNum);

			boolean boolNum = Boolean.parseBoolean(boolStr);
			System.out.println("Convert boolean value: " + boolNum);

		} catch (NumberFormatException nfe) {
			System.out.println("Invailid number" + nfe.getMessage());
		}
	}

}
