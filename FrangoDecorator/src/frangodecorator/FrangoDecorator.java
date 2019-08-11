package frangodecorator;
import interfaces.Pizza;
import interfaces.PizzaDecorator;

public class FrangoDecorator extends PizzaDecorator{

	public FrangoDecorator(Pizza pizzaDecorator) {
		super(pizzaDecorator);
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
