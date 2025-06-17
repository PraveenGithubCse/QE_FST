package Practice;

public class PizzaOrderSystem {
	public Pizza createPizza(String size,String crustType, String topping)
	{
		return new Pizza(size,crustType,topping);
	}
	
	public boolean processOrder(Pizza pizza)
	{
		return pizza.order();
	}
}
