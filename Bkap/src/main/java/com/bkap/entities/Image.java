package com.bkap.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "images")
public class Image extends BaseEntity {
	@Column(name = "displayName")
	private String displayName;
	
	@Column(name = "linkImage")
	private String linkImage;
	
	@ManyToOne
	@JoinColumn(name = "product_Id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "advertisement_Id")
	private Advertisement advertisement;
	
	@OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Image(String displayName, String linkImage, Product product, Advertisement advertisement, Account account) {
		super();
		this.displayName = displayName;
		this.linkImage = linkImage;
		this.product = product;
		this.advertisement = advertisement;
		this.account = account;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getLinkImage() {
		return linkImage;
	}

	public void setLinkImage(String linkImage) {
		this.linkImage = linkImage;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Advertisement getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(Advertisement advertisement) {
		this.advertisement = advertisement;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
