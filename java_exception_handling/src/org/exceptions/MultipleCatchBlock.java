package org.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.FileSystemNotFoundException;

public class MultipleCatchBlock {

	public static void main(String[] args) throws FileNotFoundException {
		try {
			int[] numbers = { 1, 2, 3 };
			System.out.println(numbers[10]);

			String str = "abc";
			int num = Integer.parseInt(str);

			FileReader file = new FileReader("test.txt");

//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println(e);
//		} catch (NumberFormatException e) {
//			System.out.println(e);
//		} catch (FileSystemNotFoundException e) {
//			System.out.println(e);
//		} catch (Exception e) {
//			System.out.println("An Unexpected exception occurred.");
//		}
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException | FileSystemNotFoundException anf) {
			System.err.println(anf);
			//There should not be any relation between (child | parent) or (parent to child).
		}

		System.out.println("Program continues after handling excepption...");
	}

}
