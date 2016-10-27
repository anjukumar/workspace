package customTools;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Samazonuser;

public class DbUserUtil {
	public static Samazonuser getUser(long userID) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		Samazonuser user = em.find(Samazonuser.class, userID);
		return user;
	}

	public static void insert(Samazonuser user) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		// System.out.println("DbGradebook: begin transaction");
		try {
			trans.begin();
			em.persist(user);
			// System.out.println("DbGradebook: commit transaction");
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println("DbGradebook: rollback transaction");
			trans.rollback();
			throw(e);
		} finally {
			// System.out.println("DbGradebook: close em");
			em.close();
		}
	}

	/**
	 * Updates the data in a User Pass the method a User with all the values
	 * set to your liking and this method will update the database with these
	 * values. This method doesn't actually return anything but the good feeling
	 * that your update has been completed. If it can't be completed then it
	 * won't tell you. Sounds like something needs to be added in the future.
	 * Hmmm.
	 * 
	 * @param user
	 */
	public static void update(Samazonuser user) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	/**
	 * Removes a User from the database. Not sure why you'd want to delete a
	 * User from the database but this method will do it for you. This method
	 * does not explicitly remove the user's posts but most likely you've set up
	 * the database with cascading deletes which will take care of that.Gives no
	 * feedback.
	 * 
	 * @param user
	 *            that you never want to see again
	 */
	public static void delete(Samazonuser user) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(user));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	/**
	 * Gets a user given their email address. You've got the email when they log
	 * in but you really need the user and all its related information This
	 * method will find the user matching that email. The database should ensure
	 * that you can't have two users with the same email. Otherwise there's no
	 * telling what you'd get.
	 * 
	 * @param email
	 * @return User with that unique email address
	 */
	public static Samazonuser getUserByEmail(String useremail) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		String qString = "Select s from Samazonuser s " + "where s.useremail = :useremail";
		TypedQuery<Samazonuser> q = em.createQuery(qString, Samazonuser.class);
		q.setParameter("useremail", useremail);
		Samazonuser user = null;
		try {
			user = q.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return user;

	}

	/**
	 * Is this user valid? This method has the answer for you. Checks the
	 * database and counts the number of users with this username and password.
	 * If it returns 0 then either the username or password don't exist in the
	 * database. If it returns 1 then you have found the user with that username
	 * and password. If it returns >1 then you need to fix your database first.
	 * 
	 * @param user
	 *            of type User
	 * @return true or false indicating the user exists or doesn't
	 */
	public static boolean isValidUser(String useremail, String userpassword) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		String qString = "Select count(s) from Samazonuser s "
				+ "where s.useremail = :useremail and s.userpassword = :userpassword";
		TypedQuery<Long> q = em.createQuery(qString, Long.class);
		boolean result = false;
		q.setParameter("useremail", useremail);
		q.setParameter("userpassword", userpassword);

		try {
			long userId = q.getSingleResult();
			if (userId > 0) {
				result = true;
			}
		} catch (Exception e) {

			result = false;
		} finally {
			em.close();
		}
		return result;

	}

}

