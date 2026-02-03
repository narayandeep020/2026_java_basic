package org.javaio;

import java.io.PipedReader;
import java.io.PipedWriter;

public class PipedWriterDemo {

	public static void main(String[] args) {
		try {

			final PipedReader read = new PipedReader();
			@SuppressWarnings("resource")
			final PipedWriter write = new PipedWriter(read);

			Thread readThread = new Thread(new Runnable() {
				public void run() {
					try {
						int data = read.read();
						while (data != -1) {
							System.out.print((char) data);
							data = read.read();
						}
					} catch (Exception e) {
					}
				}
			});
			Thread writeThread = new Thread(new Runnable() {
				public void run() {
					try {
						write.write("Welcome to piped writer demo in java\n".toCharArray());
					} catch (Exception e) {
					}
				}
			});
			readThread.start();
			writeThread.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
