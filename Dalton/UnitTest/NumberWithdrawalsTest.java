import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;

import customTools.DbTransactions;
import customTools.DbUtil;

public class NumberWithdrawalsTest {

	@Test
	public void test() {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();


		long x = DbTransactions.numberWithdrawals("Deposit");

		System.out.println(x);
	}
}

