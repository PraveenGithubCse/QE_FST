package Example;

import java.util.HashSet;
import java.util.Set;

public class Example3 {
	public boolean haveDupli(int[] arr)
	{
		Set<Integer> hs=new HashSet<>();
		for(int x:arr)
		{
			hs.add(x);
		}
		if(arr.length==hs.size())
			return false;
		return true;
	}
	public void exceptionTest(int[] arr) throws DuplicateNumberException
	{
		if(!haveDupli(arr))
		{
			for(int x:arr)
				System.out.println(x);
		}
		else
		{
			throw new DuplicateNumberException("Array shouldn't have duplicates");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Example3 obj=new Example3();
		try
		{
			int[] arr= {1,2,3,4,5};
			int[] arr1= {1,1,2,3,4};
			obj.exceptionTest(arr);
			obj.exceptionTest(arr1);
		}
		catch(DuplicateNumberException e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("End of Program");
	}

	}


