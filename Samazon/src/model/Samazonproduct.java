package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the SAMAZONPRODUCTS database table.
 * 
 */
@Entity
@Table(name="SAMAZONPRODUCTS")
@NamedQuery(name="Samazonproduct.findAll", query="SELECT s FROM Samazonproduct s")
public class Samazonproduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productid;

	private String image;

	private int price;

	private String productcategory;

	private String productdescription;

	private String productname;

	private BigDecimal sellerid;

	//bi-directional many-to-one association to Samazoncart
	@OneToMany(mappedBy="samazonproduct")
	private List<Samazoncart> samazoncarts;

	//bi-directional many-to-one association to Samazonreview
	@OneToMany(mappedBy="samazonproduct")
	private List<Samazonreview> samazonreviews;

	public Samazonproduct() {
	}

	public long getProductid() {
		return this.productid;
	}

	public void setProductid(long productid) {
		this.productid = productid;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductcategory() {
		return this.productcategory;
	}

	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}

	public String getProductdescription() {
		return this.productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public BigDecimal getSellerid() {
		return this.sellerid;
	}

	public void setSellerid(BigDecimal sellerid) {
		this.sellerid = sellerid;
	}

	public List<Samazoncart> getSamazoncarts() {
		return this.samazoncarts;
	}

	public void setSamazoncarts(List<Samazoncart> samazoncarts) {
		this.samazoncarts = samazoncarts;
	}

	public Samazoncart addSamazoncart(Samazoncart samazoncart) {
		getSamazoncarts().add(samazoncart);
		samazoncart.setSamazonproduct(this);

		return samazoncart;
	}

	public Samazoncart removeSamazoncart(Samazoncart samazoncart) {
		getSamazoncarts().remove(samazoncart);
		samazoncart.setSamazonproduct(null);

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
		samazonreview.setSamazonproduct(this);

		return samazonreview;
	}

	public Samazonreview removeSamazonreview(Samazonreview samazonreview) {
		getSamazonreviews().remove(samazonreview);
		samazonreview.setSamazonproduct(null);

		return samazonreview;
	}

}