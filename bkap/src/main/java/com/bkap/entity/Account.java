package com.bkap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account extends BaseEntity {
	@Column(name = "displayName")
	private String displayName;

	@Column(name="email")
	private String email;

	@Column(name="password")
	private String password;

	@Column(name="roles")
	private String roles;
}
