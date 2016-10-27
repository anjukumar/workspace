package customTools;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Samazoncart;

public class DbCartUtil
{
	
	public static void insert(Samazoncart  order) {
			EntityManager em = DbUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			try {
				trans.begin();
				em.persist(order);
				trans.commit();
			} catch (Exception e) {
				e.printStackTrace();
				trans.rollback();
			} finally {
				em.close();
			}
	    }

	    public static void update(Samazoncart  order) {
			EntityManager em = DbUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			try {
				trans.begin();
				em.merge(order);
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		
	      
	    }

	    public static void delete(Samazoncart  order) {
			EntityManager em = DbUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			try {
				trans.begin();
				em.remove(em.merge(order));
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}  
	    }

	    
	    public static List<Samazoncart >getcartList (){
	        EntityManager em = DbUtil.getEmFactory().createEntityManager();
	        String qString = "select s from Samazoncart  s";
	        
	       List<Samazoncart > order = null;
	        try{
	            TypedQuery<Samazoncart > query = em.createQuery(qString,Samazoncart .class);
	            order = (List<Samazoncart>) query.getResultList();

	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        finally{
	                em.close();
	            }
	        return order;
	    }
	    

	    
	    public static List<Samazoncart >getcartList (Integer userid){
	        EntityManager em = DbUtil.getEmFactory().createEntityManager();
	        String qString = "select s from Samazoncart  s where s.samazonuser.userid =:userid";
	     
	       List<Samazoncart > order = null;
	        try{
	            TypedQuery<Samazoncart > query = em.createQuery(qString,Samazoncart .class);
	            query.setParameter("userid", userid);
	            order = (List<Samazoncart>) query.getResultList();
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        finally{
	                em.close();
	            }
	        return order;
	    }
	    
	    public static Samazoncart  productbyid (Integer productid){
	        EntityManager em = DbUtil.getEmFactory().createEntityManager();
	        String qString = "SELECT s FROM Samazoncart s where s.samazonproduct.productid =:productid AND s.cartid =:cartid";
	        
	        Samazoncart  posts = null;
	        try{
	            TypedQuery<Samazoncart > query = em.createQuery(qString,Samazoncart .class);
	            query.setParameter("productid", productid);
	      
	            posts = query.getSingleResult();

	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        finally{
	                em.close();
	            }
	        return posts;
	    }
	    
	    public static List<Samazoncart > searchproduct (String search)
	    {
	        EntityManager em = DbUtil.getEmFactory().createEntityManager();
	        List<Samazoncart > searchposts = null;
	        String qString = "select r from Samazonproduct r "
	                + "where r.rname like :search";
	        
	        try{
	            TypedQuery<Samazoncart > query = em.createQuery(qString,Samazoncart .class);
	            query.setParameter("search", "%" + search + "%");
	            searchposts = query.getResultList();
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally{
	            em.close();
	        }return searchposts;
	    }
	    
}
