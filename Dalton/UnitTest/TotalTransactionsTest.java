import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;

import customTools.DbTransactions;
import customTools.DbUtil;
import model.Daltontransaction;

public class TotalTransactionsTest {

	@Test
	public void test() {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		Daltontransaction transaction = new Daltontransaction();
		
		long x = DbTransactions.getTotalTransactions();
	
		System.out.println(x);
	}

}
