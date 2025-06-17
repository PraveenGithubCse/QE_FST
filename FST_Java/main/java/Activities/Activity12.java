package Activities;

//@FunctionalInterface
interface Addable
{
	int add(int num1,int num2);
}

public class Activity12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ad1=10,ad2=20;
		Addable a=(int num1,int num2)->ad1+ad2;
		Addable ab=(int num1,int num2)->{
			int sum=ad1+ad2;
			return sum;};
		System.out.println(a.add(ad1, ad2));
		System.out.println(ab.add(ad1, ad2));
		
	}

}
