package com.bkap.dto;

import java.util.ArrayList;
import java.util.List;

import com.bkap.entity.Image;
import com.bkap.entity.Post;

public class AccountDTO {
	private String displayName;

	private String email;

	private String password;

	private String roles;

	private Image image;

	private List<Post> posts = new ArrayList<>();

	public AccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountDTO(String displayName, String email, String password, String roles, Image image, List<Post> posts) {
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
