package com.bkap.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "actions")
public class Action extends BaseEntity {
	@Column(name = "type")
	private String type;

	@ManyToOne
	@JoinColumn(name = "account_Id")
	private Account account;

	public Action() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Action(String type, Account account) {
		super();
		this.type = type;
		this.account = account;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}