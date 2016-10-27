import static org.junit.Assert.*;
import javax.persistence.EntityManager;
import org.junit.Test;
import customTools.DbAccount;
import customTools.DbUtil;


public class NumberSavingTest {

	@Test
	public void test() {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		long x = DbAccount.numberSavings("Saving");
		System.out.println(x);
	}
}

