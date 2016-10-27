package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DALTONTRANSACTIONS database table.
 * 
 */
@Entity
@Table(name="DALTONTRANSACTIONS")
@NamedQuery(name="Daltontransaction.findAll", query="SELECT d FROM Daltontransaction d")
public class Daltontransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long transactionid;

	private long amount;

	private String transactiondate;

	private String trantype;

	//bi-directional many-to-one association to Daltonaccount
	@ManyToOne
	@JoinColumn(name="ACCOUNTID")
	private Daltonaccount daltonaccount;

	public Daltontransaction() {
	}

	public long getTransactionid() {
		return this.transactionid;
	}

	public void setTransactionid(long transactionid) {
		this.transactionid = transactionid;
	}

	public long getAmount() {
		return this.amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getTransactiondate() {
		return this.transactiondate;
	}

	public void setTransactiondate(String transactiondate) {
		this.transactiondate = transactiondate;
	}

	public String getTrantype() {
		return this.trantype;
	}

	public void setTrantype(String trantype) {
		this.trantype = trantype;
	}

	public Daltonaccount getDaltonaccount() {
		return this.daltonaccount;
	}

	public void setDaltonaccount(Daltonaccount daltonaccount) {
		this.daltonaccount = daltonaccount;
	}

}