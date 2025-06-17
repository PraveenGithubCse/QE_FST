package Activities;

import java.util.HashSet;

public class Activity10 {
	public static void main(String[] args) {
		HashSet<String> hs=new HashSet<>();
		hs.add("A");
		hs.add("B");
		hs.add("C");
		hs.add("D");
		hs.add("E");
		hs.add("F");
		System.out.println(hs.size());
		System.out.println(hs.remove("E"));
		System.out.println(hs.remove("H"));
		System.out.println(hs.contains("C"));
		for(String x:hs)
		{
			System.out.println(x);
		}
	}
}
