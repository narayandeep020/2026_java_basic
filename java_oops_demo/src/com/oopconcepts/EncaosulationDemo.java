package com.oopconcepts;

class Account {
	private long acc_no;
	private String name;
	private float amount;

// Setter Methods
	public void setAcc_no(long acc) {
		this.acc_no = acc;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public long getAcc_no() {
		return acc_no;
	}

	public String getName() {
		return name;
	}

	public float getAmount() {
		return amount;
	}
}

public class EncaosulationDemo {

	public static void main(String[] args) {
		Account ac = new Account();
		ac.setAcc_no(377924467);
		ac.setName("Deep");
		ac.setAmount(1001);
		System.out.println("acc_no: " + ac.getAcc_no()+"\n" + "name:" + ac.getName()+"\n" + "amount:" + ac.getAmount());
	}

}
