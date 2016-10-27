package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DALTONACCOUNTS database table.
 * 
 */
@Entity
@Table(name="DALTONACCOUNTS")
@NamedQuery(name="Daltonaccount.findAll", query="SELECT d FROM Daltonaccount d")
public class Daltonaccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long accountid;

	private String accountnumber;

	private String accounttype;

	private String dateclosed;

	private String dateopened;

	//bi-directional many-to-one association to Daltoncustomer
	@ManyToOne
	@JoinColumn(name="CUSTID")
	private Daltoncustomer daltoncustomer;

	//bi-directional many-to-one association to Daltontransaction
	@OneToMany(mappedBy="daltonaccount")
	private List<Daltontransaction> daltontransactions;

	public Daltonaccount() {
	}

	public long getAccountid() {
		return this.accountid;
	}

	public void setAccountid(long accountid) {
		this.accountid = accountid;
	}

	public String getAccountnumber() {
		return this.accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getAccounttype() {
		return this.accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String getDateclosed() {
		return this.dateclosed;
	}

	public void setDateclosed(String dateclosed) {
		this.dateclosed = dateclosed;
	}

	public String getDateopened() {
		return this.dateopened;
	}

	public void setDateopened(String dateopened) {
		this.dateopened = dateopened;
	}

	public Daltoncustomer getDaltoncustomer() {
		return this.daltoncustomer;
	}

	public void setDaltoncustomer(Daltoncustomer daltoncustomer) {
		this.daltoncustomer = daltoncustomer;
	}

	public List<Daltontransaction> getDaltontransactions() {
		return this.daltontransactions;
	}

	public void setDaltontransactions(List<Daltontransaction> daltontransactions) {
		this.daltontransactions = daltontransactions;
	}

	public Daltontransaction addDaltontransaction(Daltontransaction daltontransaction) {
		getDaltontransactions().add(daltontransaction);
		daltontransaction.setDaltonaccount(this);

		return daltontransaction;
	}

	public Daltontransaction removeDaltontransaction(Daltontransaction daltontransaction) {
		getDaltontransactions().remove(daltontransaction);
		daltontransaction.setDaltonaccount(null);

		return daltontransaction;
	}

}