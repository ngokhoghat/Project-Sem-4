package com.bkap.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "settings")
public class Setting extends BaseEntity {
	@Column(name = "displayName")
	private String displayName;

	@Column(name = "content")
	private String content;

	@Column(name = "status")
	private String status;

	public Setting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Setting(String displayName, String content, String status) {
		super();
		this.displayName = displayName;
		this.content = content;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
