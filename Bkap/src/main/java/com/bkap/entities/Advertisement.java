package com.bkap.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "advertisements")
public class Advertisement extends BaseEntity {
	@Column(name = "displayName")
	private String displayName;

	@Column(name = "content")
	private String content;

	@Column(name = "type")
	private String type;

	@Column(name = "advertisementOrder")
	private Integer advertisementOrder;

	@Column(name = "status")
	private String status;

	@Column(name = "isUse")
	private Boolean isUse;

	@Column(name = "btnIsUse")
	private Boolean btnIsUse;

	@Column(name = "btnName")
	private String btnName;

	@Column(name = "btnLink")
	private String btnLink;

	@OneToMany(mappedBy = "advertisement")
	private List<Image> images = new ArrayList<>();

	public Advertisement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Advertisement(String displayName, String content, String type, Integer advertisementOrder, String status,
			Boolean isUse, Boolean btnIsUse, String btnName, String btnLink, List<Image> images) {
		super();
		this.displayName = displayName;
		this.content = content;
		this.type = type;
		this.advertisementOrder = advertisementOrder;
		this.status = status;
		this.isUse = isUse;
		this.btnIsUse = btnIsUse;
		this.btnName = btnName;
		this.btnLink = btnLink;
		this.images = images;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getAdvertisementOrder() {
		return advertisementOrder;
	}

	public void setAdvertisementOrder(Integer advertisementOrder) {
		this.advertisementOrder = advertisementOrder;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getIsUse() {
		return isUse;
	}

	public void setIsUse(Boolean isUse) {
		this.isUse = isUse;
	}

	public Boolean getBtnIsUse() {
		return btnIsUse;
	}

	public void setBtnIsUse(Boolean btnIsUse) {
		this.btnIsUse = btnIsUse;
	}

	public String getBtnName() {
		return btnName;
	}

	public void setBtnName(String btnName) {
		this.btnName = btnName;
	}

	public String getBtnLink() {
		return btnLink;
	}

	public void setBtnLink(String btnLink) {
		this.btnLink = btnLink;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
}
