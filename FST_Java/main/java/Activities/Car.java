package Activities;

public class Car {
	private String color;
	private String transmission;
	private int make;
	private int tyres;
	private int doors;
	Car(String color, String transmission, int make)
	{
		this.color=color;
		this.transmission=transmission;
		this.make=make;
		this.tyres=4;
		this.doors=4;
	}
	public void displayCharacteristics()
	{
		System.out.println("Color:"+ this.color);
		System.out.println("Transmission:"+ this.transmission);
		System.out.println("Make:"+ this.make);
		System.out.println("Tyres:"+ this.tyres);
		System.out.println("Doors:"+ this.doors);
	}
	public void accelarate()
	{
		System.out.println("Car is accelerating");
	}
	public void brake()
	{
		System.out.println("The car has stopped");
	}
}
