package org.exceptions;

public class FinalizeDemo {

	public static void main(String[] args) {
		FinalizeDemo fd = new FinalizeDemo();
		System.out.println("Hashcode is: " + fd.hashCode());
		fd = null;
		System.gc();

		try {
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End of the garbage collection");
	}

	@Override
	protected void finalize() {
		System.out.println("Called the Finalize() method.");
	}

}
