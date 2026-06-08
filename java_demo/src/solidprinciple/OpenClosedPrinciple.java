package solidprinciple;

abstract class PaymentProcessor {
	public abstract void processPayment(double amount);
}

class CreditCardPaymentProcessor extends PaymentProcessor {
	public void processPayment(double amount) {
		System.out.println("Processing credit card payment of $: " + amount);
	}
}

class PayPalPaymentProcessor extends PaymentProcessor {
	public void processPayment(double amount) {
		System.out.println("Processing Pay Pal Payment of $: " + amount);
	}

}

public class OpenClosedPrinciple {

	public static void processPayment(PaymentProcessor process, double amount) {
		process.processPayment(amount);
	}

	public static void main(String[] args) {

		CreditCardPaymentProcessor ccpp = new CreditCardPaymentProcessor();
		PayPalPaymentProcessor ppp = new PayPalPaymentProcessor();

		processPayment(ccpp, 100.00);
		processPayment(ppp, 150.00);
	}

}
