import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;

import customTools.DbTransactions;
import customTools.DbUtil;

public class TotalFee
{
	@Test
	public void test() {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		long x = DbTransactions.TotalDeposits("Withdraw-bank fee");
		System.out.println(x);
	}
}
