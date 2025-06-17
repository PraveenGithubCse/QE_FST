package Activities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomScannerActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		List<Integer> l=new ArrayList<>();
		Random r=new Random();
		l.add(r.nextInt());
		l.add(r.nextInt());
		l.add(r.nextInt());
		l.add(r.nextInt());
		l.add(r.nextInt());
		for(int x:l)
		{
			System.out.println(x);
		}
	}

}
