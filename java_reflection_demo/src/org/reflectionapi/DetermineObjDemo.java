package org.reflectionapi;

class General {
}

interface My {
}

public class DetermineObjDemo {

	public static void main(String[] args) {

		try {
			Class<?> c = Class.forName("org.reflectionapi.General");
			System.out.println(c.isInterface());

			Class<?> c2 = Class.forName("org.reflectionapi.My");
			System.out.println(c2.isInterface());

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
