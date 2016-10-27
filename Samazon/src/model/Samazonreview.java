package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SAMAZONREVIEW database table.
 * 
 */
@Entity
@NamedQuery(name="Samazonreview.findAll", query="SELECT s FROM Samazonreview s")
public class Samazonreview implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long reviewid;

	private BigDecimal rating;

	private String review;

	private String reviewdate;

	//bi-directional many-to-one association to Samazonproduct
	@ManyToOne
	@JoinColumn(name="PRODUCTID")
	private Samazonproduct samazonproduct;

	//bi-directional many-to-one association to Samazonuser
	@ManyToOne
	@JoinColumn(name="USERID")
	private Samazonuser samazonuser;

	public Samazonreview() {
	}

	public long getReviewid() {
		return this.reviewid;
	}

	public void setReviewid(long reviewid) {
		this.reviewid = reviewid;
	}

	public BigDecimal getRating() {
		return this.rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public String getReview() {
		return this.review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getReviewdate() {
		return this.reviewdate;
	}

	public void setReviewdate(String reviewdate) {
		this.reviewdate = reviewdate;
	}

	public Samazonproduct getSamazonproduct() {
		return this.samazonproduct;
	}

	public void setSamazonproduct(Samazonproduct samazonproduct) {
		this.samazonproduct = samazonproduct;
	}

	public Samazonuser getSamazonuser() {
		return this.samazonuser;
	}

	public void setSamazonuser(Samazonuser samazonuser) {
		this.samazonuser = samazonuser;
	}

}