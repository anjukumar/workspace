import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;

import customTools.DbTransactions;
import customTools.DbUtil;

public class TotalDeposit {

	@Test
	public void test() {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();


		long x = DbTransactions.TotalDeposits("Deposit");

		System.out.println(x);
	}
}
