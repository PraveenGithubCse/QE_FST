package Activities;

import java.math.BigInteger;
import java.util.Scanner;

public class Activity3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		double sec=sc.nextDouble();
		double Earth=31557600;
		double Mercury=0.240867;
		double Venus=0.61519726;
		double Jupiter=11.862615;
		double Saturn=29.447498;
		double Uranus=84.016846;
		double Neptune=164.79132;
		double Mars=1.8808158;
		System.out.println("Age of Mercury : "+sec/Earth/Mercury+" Years");
		System.out.println("Age of Earth : "+sec/Earth+" Years");
		System.out.println("Age of Venus : "+sec/Earth/Venus+" Years");
		System.out.println("Age of Jupiter : "+sec/Earth/Jupiter+" Years");
		System.out.println("Age of Saturn : "+sec/Earth/Saturn+" Years");
		System.out.println("Age of Uranus : "+sec/Earth/Uranus+" Years");
		System.out.println("Age of Neptune : "+sec/Earth/Neptune+" Years");
		System.out.println("Age of Mars : "+sec/Earth/Mars+" Years");
	}

}
