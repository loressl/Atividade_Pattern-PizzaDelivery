package pizzabasic;
import interfaces.Pizza;

public class PizzaBasic implements Pizza{

	@Override
	public void mountPizza() {
		System.out.println("Pizza B�sica");
	}

	@Override
	public String getDescription() {
		return "Pizza B�sica";
	}
}
