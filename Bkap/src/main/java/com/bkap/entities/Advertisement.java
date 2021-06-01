package com.bkap.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "advertisement")
public class Advertisement extends BaseEntity {
	@Column(name = "displayName")
	private String displayName;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "status")
	private String status;
	
	@OneToMany(mappedBy = "advertisement")
	private List<Image> images = new ArrayList<>();

	public Advertisement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Advertisement(String displayName, String content, String type, String status, List<Image> images) {
		super();
		this.displayName = displayName;
		this.content = content;
		this.type = type;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
	
}
