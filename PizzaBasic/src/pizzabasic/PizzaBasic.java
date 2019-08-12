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
		System.out.println("Pizza B�sica");
	}

	@Override
	public String getDescription() {
		return "Pizza B�sica";
	}

}
