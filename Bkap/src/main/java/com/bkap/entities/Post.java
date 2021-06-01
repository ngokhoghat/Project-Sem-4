package com.bkap.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post extends BaseEntity {
	@Column(name = "displayName")
	private String displayName;

	@Column(name = "content")
	private String content;

	@Column(name = "status")
	private String status;

	@ManyToOne
	@JoinColumn(name = "account_Id")
	private Account account;

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(String displayName, String content, String status, Account account) {
		super();
		this.displayName = displayName;
		this.content = content;
		this.status = status;
		this.account = account;
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
