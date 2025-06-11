package Activities;

import java.util.Scanner;

public class Activity2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int sum=0;
		int n=sc.nextInt();
		int arr[]= new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		for(int x: arr)
		{
			if(x==10)
			{
				sum+=x;
			}
		}
		if (sum==30)
		{
			System.out.println("True");
		}
		else
		{
			System.out.println("False");
		}
	}
}
