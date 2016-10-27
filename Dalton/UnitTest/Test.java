import static org.junit.Assert.*;

import java.util.List;

import customTools.DbCustomers;
import model.Daltoncustomer;

public class Test {

	@org.junit.Test
	public void test() {
	    
		
		
		List<Daltoncustomer> customers = DbCustomers.Daltoncustomer(1);

	    System.out.println(customers);
	    int numberofaccounts = customers.get(0).getDaltonaccounts().size();
		System.out.println("Customer has "   +numberofaccounts +"accounts");
		long balance = 0;
		for(int i =0 ; i< numberofaccounts;i ++)
		{
			int numberOfTransactions = customers.get(0).getDaltonaccounts().get(i).getDaltontransactions().size();
			System.out.println("Number of transactions Account Number: " +i +" has  is "  +numberOfTransactions);
			for(int j = 0 ; j<numberOfTransactions; j++) 
			{
				balance = customers.get(0).getDaltonaccounts().get(i).getDaltontransactions().get(j).getAmount();
			}
			System.out.println("Current Balance is : " +balance);
		
		}
	}
	
	public void test3(){
		
	}

}
