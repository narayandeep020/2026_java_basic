package org.filehandling;

import java.io.FilePermission;
import java.security.PermissionCollection;

public class FilePermissionExample {

	public static void main(String[] args) {
		String srg = "E:\\2026_java_git_workspace\\java_exception_handling\\test.txt";

		FilePermission f1 = new FilePermission("E:\\2026_java_git_workspace\\java_exception_handling\\-", "read");
		PermissionCollection pc = f1.newPermissionCollection();
		pc.add(f1);

		FilePermission f2 = new FilePermission(srg, "write");
		pc.add(f2);
		if (pc.implies(new FilePermission(srg, "read,write"))) {
			System.out.println("Read, Write permission is granted of path: " + srg);
		} else {
			System.out.println("NoRead,Write permission i s granted for path: " + srg);
		}
	}

}
