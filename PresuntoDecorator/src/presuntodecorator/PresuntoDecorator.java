package presuntodecorator;
import interfaces.Pizza;
import interfaces.PizzaDecorator;

public class PresuntoDecorator extends PizzaDecorator{

	public PresuntoDecorator(Pizza pizzaDecorator) {
		super(pizzaDecorator);
	}

	@Override
	public void mountPizza() {
		super.mountPizza();
		System.out.println(" + presunto");
	}
	
	@Override
	public String getDescription() {
		return "Presunto";
	}

}
