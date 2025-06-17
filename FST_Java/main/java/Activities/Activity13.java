package Activities;

import java.util.Random;
import java.util.Scanner;

public class Activity13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		Random r=new Random();
		int ran=r.nextInt(0, n);
		System.out.println(ran+" "+arr[ran]);
		sc.close();
	}

}
