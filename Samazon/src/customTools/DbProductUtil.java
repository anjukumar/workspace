package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Samazonproduct;




public class DbProductUtil {

    public static void insert(Samazonproduct product) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(product);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	
       
    }

    public static void update(Samazonproduct product) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(product);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	
      
    }

    public static void delete(Samazonproduct product) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(product));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	
        
    }

    public static List<Samazonproduct> product(){
        EntityManager em = DbUtil.getEmFactory().createEntityManager();
        String qString = "select s from Samazonproduct s";
        
        List<Samazonproduct> product = null;
        try{
            TypedQuery<Samazonproduct> query = em.createQuery(qString,Samazonproduct.class);
            product = query.getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
                em.close();
            }
        return product;
    }
    

    
    
    public static Samazonproduct productbyid (Integer productid){
        EntityManager em = DbUtil.getEmFactory().createEntityManager();
        String qString = "select s from Samazonproduct s where s.productid =:productid";
        
        Samazonproduct posts = null;
        try{
            TypedQuery<Samazonproduct> query = em.createQuery(qString,Samazonproduct.class);
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
    
    public static List<Samazonproduct> searchproduct (String search)
    {
        EntityManager em = DbUtil.getEmFactory().createEntityManager();
        List<Samazonproduct> searchposts = null;
        String qString = "select r from Samazonproduct r "
                + "where r.rname like :search";
        
        try{
            TypedQuery<Samazonproduct> query = em.createQuery(qString,Samazonproduct.class);
            query.setParameter("search", "%" + search + "%");
            searchposts = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }return searchposts;
    }
    
}
