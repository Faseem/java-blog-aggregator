package com.fsm.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.fsm.app.annotation.UniqueUserName;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=3, message="Name Should be atleast 3 charecters!")
	@Column(unique=true)
	@UniqueUserName(message="Such User Name Already exixsts !!")
	private String name;
	
	@Size(min=1, message="Invalid Email Address!")
	@Email(message="Invalid Email Address!")
	private String email;
	
	@Size(min=5, message="Password Should be atleast 5 charectors!")
	private String password;
	
	private boolean enabled;
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@ManyToMany
	@JoinTable
	private List<Role> roles;
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
	private List<Blog> blogs;

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
