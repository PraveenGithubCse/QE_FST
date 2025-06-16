package Example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		if(a==b && b==c && c==a)
		{
			System.out.println("All are equal");
		}
		else if(a!=b && b!=c && c!=a)
		{
			System.out.println("All are not equal");
		}
		else if(a==b || b==c || c==a)
		{
			System.out.println("Two are equal");
		}
	}

}
