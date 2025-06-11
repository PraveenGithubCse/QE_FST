package Activities;

public class CustomException extends Exception {
	private String message;
	public CustomException(String message) 
	{
		// TODO Auto-generated constructor stub
		this.message=message;
	}
	public String getMessage()
	{
		return "The error happened because:"+this.message;
	}
	


}
