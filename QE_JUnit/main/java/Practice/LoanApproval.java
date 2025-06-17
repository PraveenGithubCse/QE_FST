package Practice;

public class LoanApproval {

	public String approveLoan(boolean salaried, double monthlyIncome)
	{
		if(monthlyIncome>=75000.00)
		{
			if(salaried)
			{
				return "Approved";
			}
			else
			{
				return "Visit Bank";
			}
		}
			else if(salaried&&monthlyIncome>=25000)
			{
				return "Visit Bank";
			}
			return "Rejected";
		
	}
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
