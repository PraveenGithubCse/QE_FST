package Practice;

public class Pizza {
	private String size;
	private String crustType;
	private String topping;
	private boolean isOrdered;
	public Pizza(String size, String crustType, String topping) 
	{
		this.size = size;
		this.crustType = crustType;
		this.topping = topping;
		this.isOrdered = isOrdered;
	}
	
	public String getSize() {
		return size;
	}
	
	public String getCrustType() {
		return crustType;
	}
	
	public String getTopping() {
		return topping;
	}
	
	public boolean isOrdered() {
		return isOrdered;
	}
	
	 //ordering pizza
	public boolean order()
	{
		if(isvalidCombination())
		{
			this.isOrdered=true;
			return true;
		}
		return false;
	}
	
	//check for valid pizza
	private boolean isvalidCombination()
	{
		return size!=null && crustType!=null && topping !=null;
	}
	
	//get price of pizza
	public double getPrice()
	{
		double basePrice=0;
		
		//size pricing 
		switch(size.toLowerCase())
		{
		case "small":
			basePrice=10.00;
			break;
		case "medium":
			basePrice=12.00;
			break;
		case "large":
			basePrice=15.00;
			break;
		
		}
		
		//crust type pricing
		if("thick".equals(crustType.toLowerCase()))
		{
			basePrice+=2.00;
		}
		//topping pricing 
		if(!"cheese".equals(topping.toLowerCase()))
		{
			basePrice+=1.50;
		}
		return basePrice;
	}
	
}
