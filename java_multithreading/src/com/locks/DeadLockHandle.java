package com.locks;

public class DeadLockHandle {

	public static void main(String[] args) {

		DeadLockHandle dl = new DeadLockHandle();
		final resource1 a = dl.new resource1();
		final resource2 b = dl.new resource2();

		Runnable b1 = new Runnable() {
			public void run() {
				synchronized (b) {
					try {
						Thread.sleep(500);
					} catch (Exception e) {
						e.printStackTrace();
					}
					synchronized (a) {
						System.out.println("In block 1.");
					}
				}
			}
		};
		Runnable b2 = new Runnable() {
			public void run() {
				synchronized (b) {
					synchronized (a) {
						System.out.println("In block 2.");
					}
				}
			}
		};
		new Thread(b1).start();
		new Thread(b2).start();
	}

	private class resource1 {
		private int i = 10;

		public int getl() {
			return i;
		}

		public void setl(int i) {
			this.i = i;
		}
	}

	private class resource2 {
		private int i = 20;

		public int getl() {
			return i;
		}

		public void setl() {
			this.i = i;
		}
	}

}
