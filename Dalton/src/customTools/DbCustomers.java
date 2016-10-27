package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Daltoncustomer;

public class DbCustomers {

    public static List<Daltoncustomer> Daltoncustomer (){
        EntityManager em = DbUtil.getEmFactory().createEntityManager();
        String qString = "SELECT d FROM Daltoncustomer d";
        
        List<Daltoncustomer> customers = null;
        try{
            TypedQuery<Daltoncustomer> query = em.createQuery(qString,Daltoncustomer.class);
            customers = query.getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return customers;
    }

    public static List<Daltoncustomer> Daltoncustomer (long custid){
        EntityManager em = DbUtil.getEmFactory().createEntityManager();
        String qString = "SELECT d FROM Daltoncustomer d where d.custid = :custid";
        
        List<Daltoncustomer> customers = null;
        try{
            TypedQuery<Daltoncustomer> query = em.createQuery(qString,Daltoncustomer.class);
        	query.setParameter("custid", custid);
            customers = query.getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return customers;
    }
	
	
}
