package Activities;

public class Activity8 {
	public void exceptionTest(String str) throws CustomException
	{
		if(str.isEmpty())
		{
			throw new CustomException("String can't be empty");
		}
		else
		{
			System.out.println(str);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Activity8 obj=new Activity8();
		try
		{
			obj.exceptionTest("This will be printed");
			obj.exceptionTest("");
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("End of Program");
	}

}
