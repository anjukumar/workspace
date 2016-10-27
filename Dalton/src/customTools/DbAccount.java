package customTools;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DbAccount {
	
public static long numberCheckings( String accounttype){
		
        EntityManager em = DbUtil.getEmFactory().createEntityManager();
        String qString = "SELECT count(d.accountid) FROM Daltonaccount d where d.accounttype = :accounttype";
        
       long numberCheckings = 0l;
        try{
            TypedQuery<Long> query = em.createQuery(qString, Long.class);
            query.setParameter("accounttype", accounttype);
            numberCheckings = query.getSingleResult();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return numberCheckings;
    }
public static long numberSavings( String accounttype){
	
    EntityManager em = DbUtil.getEmFactory().createEntityManager();
    String qString = "SELECT count(d.accountid) FROM Daltonaccount d where d.accounttype = :accounttype";
    
   long numberSavings = 0l;
    try{
        TypedQuery<Long> query = em.createQuery(qString, Long.class);
        query.setParameter("accounttype", accounttype);
        numberSavings = query.getSingleResult();

    }catch (Exception e){
        e.printStackTrace();
    }
    finally{
            em.close();
        }
    return numberSavings;
}

}
