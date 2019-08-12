package frangodecorator;
import interfaces.IPlugin;
import interfaces.Pizza;
import interfaces.PizzaDecorator;

public class FrangoDecorator extends PizzaDecorator implements IPlugin{

	public FrangoDecorator(Pizza pizzaDecorator) {
		super(pizzaDecorator);
	}
	
	@Override
	public boolean initialize() {
		return true;
	}
	
	@Override
	public void mountPizza() {
		super.mountPizza();
		System.out.println(" + frango");
	}

	@Override
	public String getDescription() {
		return "Frango";
	}
}
