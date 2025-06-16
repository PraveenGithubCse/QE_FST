package Example;

public class DuplicateNumberException extends Exception{
	private String message;
	public DuplicateNumberException(String message) 
	{
		// TODO Auto-generated constructor stub
		this.message=message;
	}
	public String getMessage()
	{
		return "The error happened because:"+this.message;
	}
}
