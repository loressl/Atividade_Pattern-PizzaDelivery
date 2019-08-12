package azeitonadecorator;
import interfaces.IPlugin;
import interfaces.Pizza;
import interfaces.PizzaDecorator;

public class AzeitonaDecorator extends PizzaDecorator implements IPlugin{

	public AzeitonaDecorator(Pizza pizzaDecorator) {
		super(pizzaDecorator);
	}

	@Override
	public boolean initialize() {
		return true;
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
