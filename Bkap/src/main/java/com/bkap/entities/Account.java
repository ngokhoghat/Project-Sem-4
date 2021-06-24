package com.bkap.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account extends BaseEntity {
	@Column(name = "displayName")
	private String displayName;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "roles")
	private String roles;

	@OneToOne(mappedBy = "account")
	private Image image;

	@OneToMany(mappedBy = "account")
	private List<Post> posts = new ArrayList<>();

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String displayName, String email, String password, String roles, Image image, List<Post> posts) {
		super();
		this.displayName = displayName;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.image = image;
		this.posts = posts;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
}
