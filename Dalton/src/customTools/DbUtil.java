
package customTools;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbUtil {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Dalton");
	public static EntityManagerFactory getEmFactory(){
		return emf;
	}
}
