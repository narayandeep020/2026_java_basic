package org.filehandling;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileMultiple {

	public static void main(String[] args) {
		try {
			String fileName1 = "test.txt";
			String fileName2 = "abc.txt";

			String zipFilename = "Allfiles.zip";
			File zipFile = new File(zipFilename);
			FileOutputStream fos = new FileOutputStream(zipFile);
			ZipOutputStream zos = new ZipOutputStream(fos);
			zipFile(fileName1, zos);
			zipFile(fileName2, zos);
			zos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void zipFile(String fileName, ZipOutputStream zos) throws IOException {
		final int BUFFER = 1024;
		BufferedInputStream bis = null;
		try {
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis, BUFFER);

			ZipEntry ze = new ZipEntry(file.getName());
			zos.putNextEntry(ze);
			byte data[] = new byte[BUFFER];
			int count;
			while ((count = bis.read(data, 0, BUFFER)) != -1) {
				zos.write(data, 0, count);
			}
			zos.closeEntry();
		} finally {
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
