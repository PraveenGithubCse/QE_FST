package Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Example5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		char c[]=str.toLowerCase().toCharArray();
		List<String> resVow= new ArrayList<>();
		List<String> resCon= new ArrayList<>();
		List<String> resSym= new ArrayList<>();
		for(char x: c)
		{
			if(x=='a' || x=='e' || x=='i' || x=='o' || x=='u')
			{
				resVow.add(String.valueOf(x));
			}
			else if(!Character.isAlphabetic(x))
			{
				resSym.add(String.valueOf(x));
			}
			else
			{
				resCon.add(String.valueOf(x));
			}
		}
		System.out.println("The Vowels in the String is: ");
		for(String x:resVow)
			System.out.print(x);
		System.out.println("\nThe Consonants in the String is: ");
		for(String x:resCon)
			System.out.print(x);
		System.out.println("\nThe Punctuations in the String is: ");
		for(String x:resSym)
			System.out.print(x);
	}

}
