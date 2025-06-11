package Activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Plane {
	private int maxPassengers;
	private List<String> passengers;
	private Date lastTimeTookOf;
	private Date lastTimeLanded;

	public Plane(int maxPassengers) {
		this.maxPassengers = maxPassengers;
		this.passengers = new ArrayList<>();
	}

	public void onBoard(String name) {
		if (passengers.size() < maxPassengers) {
			passengers.add(name);
			System.out.println(name);
		} else {
			System.out.println("Plane is Full");
		}
	}

	public Date takeOff() {
		this.lastTimeTookOf = new Date();
		return lastTimeTookOf;

	}

	public void setland() {
		this.lastTimeLanded = new Date();
		this.passengers.clear();
	}

	public Date LastTimeLanded() {
		return lastTimeLanded;
	}

	public List<String> getPassengers() {
		return passengers;
	}

	public static void main(String[] args) throws InterruptedException {
		Plane p = new Plane(3);
		p.onBoard("Pandu1");
		p.onBoard("Pandu2");
		p.onBoard("Pandu3");
		p.onBoard("Pandu4");
		System.out.println(p.takeOff());
		System.out.println(p.getPassengers());
		Thread.sleep(5000);
		p.setland();
		System.out.println(p.lastTimeLanded);
		System.out.println(p.getPassengers());
	}
}