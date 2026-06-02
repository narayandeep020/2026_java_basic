package solidprinciple;

class BreadBaker {
	public void bakeBread() {
		System.out.println("Baking high-quality bread....");
	}
}

class InventoryManager {
	public void manageInventory() {
		System.out.println("Managing inventory....");
	}
}

class SupplyOrder {
	public void orderSupplies() {
		System.out.println("Ordering supplies....");
	}
}

class CustomerService {
	public void serveCustomer() {
		System.out.println("Serving customers....");
	}
}

class BakeryCleaner {
	public void cleanBakery() {
		System.out.println("Cleaning the bakery...");
	}
}

public class SingleRespPrinciple {
	public static void main(String[] args) {

		BreadBaker baker = new BreadBaker();

		InventoryManager inventory = new InventoryManager();

		SupplyOrder supply = new SupplyOrder();

		CustomerService service = new CustomerService();

		BakeryCleaner clean = new BakeryCleaner();

		baker.bakeBread();
		inventory.manageInventory();
		supply.orderSupplies();
		service.serveCustomer();
		clean.cleanBakery();

	}

}
