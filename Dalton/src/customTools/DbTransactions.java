package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Daltontransaction;


public class DbTransactions {


	public static long getTotalTransactions(){
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		String qString = "SELECT count(t.transactionid) FROM Daltontransaction t";

		long numberoftransaction = 0l;
		try{
			TypedQuery<Long> query = em.createQuery(qString, Long.class);
			numberoftransaction = query.getSingleResult();

		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
			em.close();
		}
		return numberoftransaction;
	}

	public static long numberDeposit( String trantype){

		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		String qString = "SELECT count(t.transactionid) FROM Daltontransaction t where t.trantype = :trantype";

		long numberDeposit = 0l;
		try{
			TypedQuery<Long> query = em.createQuery(qString, Long.class);
			query.setParameter("trantype", trantype);
			numberDeposit = query.getSingleResult();

		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
			em.close();
		}
		return numberDeposit;
	}

	public static long TotalDeposits(String trantype){

		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		String qString = "SELECT SUM(t.amount) FROM Daltontransaction t where t.trantype = :trantype";

		long numberDeposit = 0l;
		try{
			TypedQuery<Long> query = em.createQuery(qString, Long.class);
			query.setParameter("trantype", trantype);
			numberDeposit = query.getSingleResult();

		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
			em.close();
		}
		return numberDeposit;
	}

	public static long numberWithdrawals( String trantype){

		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		String qString = "SELECT count(t.transactionid) FROM Daltontransaction t where t.trantype <> :trantype";

		long numberWithdrawals = 0l;
		try{
			TypedQuery<Long> query = em.createQuery(qString, Long.class);
			query.setParameter("trantype", trantype);
			numberWithdrawals = query.getSingleResult();

		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
			em.close();
		}
		return numberWithdrawals;
	}

	public static long TotalWithdrawal(String trantype){

		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		String qString = "SELECT SUM(t.amount) FROM Daltontransaction t where t.trantype <> :trantype";

		long TotalWithdrawal = 0l;
		try{
			TypedQuery<Long> query = em.createQuery(qString, Long.class);
			query.setParameter("trantype", trantype);
			TotalWithdrawal = query.getSingleResult();

		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
			em.close();
		}
		return TotalWithdrawal;
	}

	public static long TotalBankFee(String trantype){

		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		String qString = "SELECT SUM(t.amount) FROM Daltontransaction t where t.trantype = :trantype";

		long TotalBankFee = 0l;
		try{
			TypedQuery<Long> query = em.createQuery(qString, Long.class);
			query.setParameter("trantype", trantype);
			TotalBankFee = query.getSingleResult();

		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
			em.close();
		}
		return TotalBankFee;
	}
}
