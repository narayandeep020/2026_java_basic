package org.filehandling;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFileRead {

	public void printFileContent(String filePath) {
		FileInputStream fis = null;
		ZipInputStream zis = null;
		ZipEntry ze = null;

		try {
			System.out.println("File in the zip are as follows: ");
			fis = new FileInputStream(filePath);
			zis = new ZipInputStream(new BufferedInputStream(fis));

			while ((ze = zis.getNextEntry()) != null) {
				System.out.println(ze.getName());
			}
			zis.close();
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String filePath = "Allfiles.zip";
		ZipFileRead zf = new ZipFileRead();
		zf.printFileContent(filePath);
	}

}
