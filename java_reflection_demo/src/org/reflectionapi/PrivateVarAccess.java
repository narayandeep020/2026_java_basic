package org.reflectionapi;

import java.lang.reflect.Method;

public class PrivateVarAccess {

	public static void main(String[] args) throws Exception {
		Class<?> c = PrivateVar.class;
		Object obj = c.newInstance();

		Method m = c.getDeclaredMethod("cube", new Class[] { int.class });
		m.setAccessible(true);
		m.invoke(obj, 4);
	}
}
