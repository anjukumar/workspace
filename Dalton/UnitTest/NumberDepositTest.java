import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;

import customTools.DbTransactions;
import customTools.DbUtil;
import model.Daltontransaction;

public class NumberDepositTest {

	@Test
	public void test() {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();


		long x = DbTransactions.numberDeposit("Deposit");

		System.out.println(x);
	}
}

