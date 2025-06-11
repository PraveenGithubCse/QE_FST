package Activities;
interface BicycleParts
{
	int tyres=2;
	int maxSpeed=20;
}

interface BicycleOperations
{
	void applyBrake(int decrementValue);
	void speedUp(int incrementValue);
}

class Bicycle implements BicycleParts,BicycleOperations
{
	int gears,currentSpeed;
	
	Bicycle(int gears, int currentSpeed)
	{
		this.gears=gears;
		this.currentSpeed=currentSpeed;
	}
	
	@Override
	public void applyBrake(int decrementValue) {
		// TODO Auto-generated method stub
		
		if(currentSpeed!=0)
		{
			currentSpeed-=decrementValue;
			System.out.println("Cycle speed decreased to "+currentSpeed);
		}
		else
		{
			System.out.println("Cycle Stopped");
		}
	}

	@Override
	public void speedUp(int incrementValue) {
		// TODO Auto-generated method stub
		if(currentSpeed!=maxSpeed)
		{
			currentSpeed+=incrementValue;
			System.out.println("Cycle speed increased to "+ currentSpeed);
		}
		else
		{
			System.out.println("Cycle at maxspeed");
		}
	}
	
	//func to describe bicycle
	public void bicycleDesc()
	{
		System.out.println("Bicycle has "+gears+" gears, "+tyres+"tyres and a maxspeed of "+maxSpeed);
		System.out.println("Its current speed is:" + currentSpeed);
	}
	
}

class MountainBike extends Bicycle
{
	int seatHeight;
	MountainBike(int gears, int currentSpeed, int seatHeight)
	{
		super(gears,currentSpeed);
		this.seatHeight=seatHeight;
	}
	
	public void setSeatHeight(int newValue)
	{
		this.seatHeight=newValue;
	}
	
	public void bicycleDesc()
	{
		System.out.println("Bicycle has "+gears+" gears, "+tyres+"tyres and a maxspeed of "+maxSpeed);
		System.out.println("Current Seat height is: "+seatHeight);
		System.out.println("Its current speed is:" + currentSpeed);
	}
}

public class Activity7 {
	public static void main(String[] args) {
		Bicycle b=new MountainBike(3, 0, 25);
		b.bicycleDesc();
		b.speedUp(20);
		b.applyBrake(5);
		
		
	}
}
