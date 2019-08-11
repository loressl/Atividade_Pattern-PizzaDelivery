package azeitonadecorator;
import interfaces.Pizza;
import interfaces.PizzaDecorator;

public class AzeitonaDecorator extends PizzaDecorator{

	public AzeitonaDecorator(Pizza pizzaDecorator) {
		super(pizzaDecorator);
	}

	@Override
	public void mountPizza() {
		super.mountPizza();
		System.out.println(" + azeitona");
	}
	
	@Override
	public String getDescription() {
		return "Azeitona";
	}

}
