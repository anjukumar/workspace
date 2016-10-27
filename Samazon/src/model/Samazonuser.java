package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SAMAZONUSER database table.
 * 
 */
@Entity
@NamedQuery(name="Samazonuser.findAll", query="SELECT s FROM Samazonuser s")
public class Samazonuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userid;

	private String address;

	private String city;

	@Column(name="\"STATE\"")
	private String state;

	private String useremail;

	private String username;

	private String userpassword;

	private String userrole;

	private String zip;

	//bi-directional many-to-one association to Samazoncart
	@OneToMany(mappedBy="samazonuser")
	private List<Samazoncart> samazoncarts;

	//bi-directional many-to-one association to Samazonreview
	@OneToMany(mappedBy="samazonuser")
	private List<Samazonreview> samazonreviews;

	public Samazonuser() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUseremail() {
		return this.useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return this.userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getUserrole() {
		return this.userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public List<Samazoncart> getSamazoncarts() {
		return this.samazoncarts;
	}

	public void setSamazoncarts(List<Samazoncart> samazoncarts) {
		this.samazoncarts = samazoncarts;
	}

	public Samazoncart addSamazoncart(Samazoncart samazoncart) {
		getSamazoncarts().add(samazoncart);
		samazoncart.setSamazonuser(this);

		return samazoncart;
	}

	public Samazoncart removeSamazoncart(Samazoncart samazoncart) {
		getSamazoncarts().remove(samazoncart);
		samazoncart.setSamazonuser(null);

		return samazoncart;
	}

	public List<Samazonreview> getSamazonreviews() {
		return this.samazonreviews;
	}

	public void setSamazonreviews(List<Samazonreview> samazonreviews) {
		this.samazonreviews = samazonreviews;
	}

	public Samazonreview addSamazonreview(Samazonreview samazonreview) {
		getSamazonreviews().add(samazonreview);
		samazonreview.setSamazonuser(this);

		return samazonreview;
	}

	public Samazonreview removeSamazonreview(Samazonreview samazonreview) {
		getSamazonreviews().remove(samazonreview);
		samazonreview.setSamazonuser(null);

		return samazonreview;
	}

}