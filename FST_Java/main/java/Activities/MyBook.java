package Activities;

public class MyBook extends Book {
	public void setTitle(String s)
	{
		title=s;
	}
	public static void main(String[] args) {
		MyBook b=new MyBook();
		b.setTitle("Return of Dragon!!");
		System.out.println(b.getTitle());
	}
}
