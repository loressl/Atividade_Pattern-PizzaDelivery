package pizzabasic;
import interfaces.IPlugin;
import interfaces.Pizza;

public class PizzaBasic implements IPlugin,Pizza{
	
	@Override
	public boolean initialize() {
		return true;
	}

	@Override
	public void mountPizza() {
		System.out.println("Pizza Básica");
	}

	@Override
	public String getDescription() {
		return "Pizza Básica";
	}

}
