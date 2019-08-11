package interfaces;

public abstract class PizzaDecorator implements Pizza{
	
	public PizzaDecorator(Pizza pizzaDecorator) {
		this.setPizzaDecorator(pizzaDecorator);
	}
	
	public void setPizzaDecorator(Pizza pizzaDecorator) {
		this.pizzaDecorator = pizzaDecorator;
	}
	
	@Override
	public void mountPizza() {
		pizzaDecorator.mountPizza();
	}
	
	protected Pizza pizzaDecorator;
}
