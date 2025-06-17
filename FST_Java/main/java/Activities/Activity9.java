package Activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {
	public static void main(String[] args) {
		List<String> l=new ArrayList<>();
		l.add("A");
		l.add("B");
		l.add("C");
		l.add("D");
		l.add("E");
		for(String x:l)
		{
			System.out.println(x);
		}
		System.out.println(l.get(3));
		System.out.println(l.contains("F"));
		System.out.println(l.size());
		System.out.println(l.remove(4));
	}
}
