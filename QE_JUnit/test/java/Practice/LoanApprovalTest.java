package Practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoanApprovalTest {
	//CREATE AN OBJECT FOR THE CLASS LOANAPPROVAL
	LoanApproval obj=new LoanApproval();
	
	//Test Case 1
	@Test
	public void salariedWithLowIncome()
	{
		//call the approveLoan func
		String status=obj.approveLoan(true, 20000);
		
		Assertions.assertEquals("Rejected", status);
	}
	
	//Test Case 2
	@Test
	public void salariedWithMidIncome()
	{
		//call the approveLoan func
		String status=obj.approveLoan(true, 60000);
		
		Assertions.assertEquals("Visit Bank", status);
	}
		
	//Test Case 3
	@Test
	public void salariedWithHighIncome()
	{
		//call the approveLoan func
		String status=obj.approveLoan(true, 75000);
		
		Assertions.assertEquals("Approved", status);
	}
	
	//Test Case 4
	@Test
	public void nonsalariedWithHighIncome()
	{
		//call the approveLoan func
		String status=obj.approveLoan(false, 85000);
		
		Assertions.assertEquals("Visit Bank", status);
	}
	
	//Test Case 5
	@Test
	public void nonsalariedWithLowIncome()
	{
		//call the approveLoan func
		String status=obj.approveLoan(false, 55000);
		
		Assertions.assertEquals("Rejected", status);
	}
}
