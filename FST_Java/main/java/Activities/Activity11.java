package Activities;

import java.util.HashMap;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap hm=new HashMap<>();
		hm.put(1, "Red");
		hm.put(2, "Green");
		hm.put(3, "Yellow");
		hm.put(4, "Black");
		hm.put(5, "Brown");
		System.out.println(hm.remove(3));
		System.out.println(hm.containsValue("Green"));
		System.out.println(hm.size());
		//print all pairs
		System.out.println(hm.entrySet());
	}

}
