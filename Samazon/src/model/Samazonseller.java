package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SAMAZONSELLER database table.
 * 
 */
@Entity
@NamedQuery(name="Samazonseller.findAll", query="SELECT s FROM Samazonseller s")
public class Samazonseller implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long sellerid;

	private String sellername;

	public Samazonseller() {
	}

	public long getSellerid() {
		return this.sellerid;
	}

	public void setSellerid(long sellerid) {
		this.sellerid = sellerid;
	}

	public String getSellername() {
		return this.sellername;
	}

	public void setSellername(String sellername) {
		this.sellername = sellername;
	}

}