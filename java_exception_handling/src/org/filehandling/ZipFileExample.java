package org.filehandling;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileExample {
	static final int BUFFER = 1024;

	public static void main(String[] args) {
		zipFile();
	}

	private static void zipFile() {
		ZipOutputStream zos = null;
		BufferedInputStream bis = null;

		try {

			String fileName1 = "test.txt";
			String fileName2 = "abc.txt";
			File file = new File(fileName1,fileName2);
			FileInputStream fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis, BUFFER);

			FileOutputStream fos = new FileOutputStream(
					"E:\\2026_java_git_workspace\\java_exception_handling\\demo.zip");
			zos = new ZipOutputStream(fos);

			ZipEntry ze = new ZipEntry(file.getName());
			zos.putNextEntry(ze);

			byte[] data = new byte[BUFFER];
			int count;
			while ((count = bis.read(data, 0, BUFFER)) != -1) {
				zos.write(data, 0, count);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (zos != null) {
				try {
					zos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
