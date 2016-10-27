import static org.junit.Assert.*;
import javax.persistence.EntityManager;
import org.junit.Test;
import customTools.DbAccount;
import customTools.DbUtil;


public class NumberCheckingTest {

	@Test
	public void test()
	{
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		long x = DbAccount.numberCheckings("Checking");
		System.out.println(x);
	}
}

