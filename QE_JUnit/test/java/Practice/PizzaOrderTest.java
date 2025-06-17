package Practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PizzaOrderTest {

	// object of the class to test
	PizzaOrderSystem orderSystem;

	// setup func
	@BeforeEach
	public void setUp() {
		orderSystem = new PizzaOrderSystem();
	}

	// Individual test cases
	@Test
	public void smallThinMushroom()
	{
		Pizza pizza=orderSystem.createPizza("small", "thin", "Mushroom");
		
		//pizza is created
		assertTrue(orderSystem.processOrder(pizza));
		assertEquals("small", pizza.getSize());
		assertEquals("thin", pizza.getCrustType());
		assertEquals("Mushroom", pizza.getTopping());
		assertTrue(pizza.isOrdered());
	}
	
	@ParameterizedTest
	@CsvSource({
	"small,thin,mushroom,11.50",
	"small,thin,onion,11.50",
	"small,thick,sausage,13.50",
	"small,thick,cheese,12.00",
	"small,thick,pepporoni,13.50",
	"medium,thin,cheese,12.00",	
	"medium,thin,sausage,13.50",
	"medium,thin,pepparoni,13.50",
	"medium,thick,onion,15.50",
	"medium,thick,mushroom,15.50",
	"large,thin,onion,16.50",
	"large,thick,cheese,17.00",
	"large,thick,sausage,18.50",
	"large,thick,mushroom,18.50",
	"large,thick,pepporoni,18.50",
	})
	
	public void testAllCombinations(String size, String crustType, String Topping, double expectedPrice)
	{
		//creating piza
		Pizza pizza= orderSystem.createPizza(size, crustType, Topping);
		
		//asserting the creation of pizza
		assertTrue(orderSystem.processOrder(pizza));
		assertTrue(pizza.isOrdered());
		//asserting the properties of the pizza
		assertEquals(size, pizza.getSize());
		assertEquals(crustType, pizza.getCrustType());
		assertEquals(Topping, pizza.getTopping());
		assertEquals(expectedPrice, pizza.getPrice());
		
		
	}
}