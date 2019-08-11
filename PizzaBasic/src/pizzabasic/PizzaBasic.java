package pizzabasic;
import interfaces.Pizza;

public class PizzaBasic implements Pizza{

	@Override
	public void mountPizza() {
		System.out.println("Pizza Básica");
	}

	@Override
	public String getDescription() {
		return "Pizza Básica";
	}
}
