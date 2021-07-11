package com.bkap.model;

public class AdvertisementBannerModel {
	public Long id;
	public String displayName;
	public String content;
	public String type;
	public Integer advertisementOrder;
	public String status;
	public Boolean isUse;
	public Boolean btnIsUse;
	public String btnName;
	public String btnLink;
	public String image;

	public AdvertisementBannerModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdvertisementBannerModel(Long id, String displayName, String content, String type,
			Integer advertisementOrder, String status, Boolean isUse, Boolean btnIsUse, String btnName, String btnLink,
			String image) {
		super();
		this.id = id;
		this.displayName = displayName;
		this.content = content;
		this.type = type;
		this.advertisementOrder = advertisementOrder;
		this.status = status;
		this.isUse = isUse;
		this.btnIsUse = btnIsUse;
		this.btnName = btnName;
		this.btnLink = btnLink;
		this.image = image;
	}
}
