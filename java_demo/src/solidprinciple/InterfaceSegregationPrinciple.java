package solidprinciple;

import java.util.Arrays;
import java.util.List;

interface IVegetarianMenu {
	List<String> getVegetarianItam();
}

interface INonVegetarianMenu {
	List<String> getNonVegetarianItem();
}

interface IDrinkMenu {
	List<String> getDrinkItam();
}

class VegetarianMenu implements IVegetarianMenu {
	public List<String> getVegetarianItam() {
		return Arrays.asList("Vegetable Curry", "Paneer Tikka", "Salad");
	}
}

class NonVegetarianMenu implements INonVegetarianMenu {
	public List<String> getNonVegetarianItem() {
		return Arrays.asList("Chicken Curry", "Fish Fry", "Mutton Curry");
	}
}

class DrinkMenu implements IDrinkMenu {
	@Override
	public List<String> getDrinkItam() {

		return Arrays.asList("Water", "Soda", "Juice");
	}
}

class MenuDisplay {
	public static void displayVegetarianMenu(IVegetarianMenu menu) {
		System.out.println("Vegetarian Menu:");
		for (String item : menu.getVegetarianItam()) {
			System.out.println("-" + item);
		}
	}

	public static void dispalyNonVegetarianMenu(INonVegetarianMenu menu) {
		System.out.println("Non-Vegetarian Menu");
		for (String item : menu.getNonVegetarianItem()) {
			System.out.println("-" + item);
		}
	}
}

public class InterfaceSegregationPrinciple {

	public static void main(String[] args) {

		VegetarianMenu vegmenu = new VegetarianMenu();
		NonVegetarianMenu nonveg = new NonVegetarianMenu();
		DrinkMenu drink = new DrinkMenu();

		MenuDisplay.displayVegetarianMenu(vegmenu);
		MenuDisplay.dispalyNonVegetarianMenu(nonveg);
	}

}
