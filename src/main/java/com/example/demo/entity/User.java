package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="instructor")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private Long id;
	
	@Column(name="FirstName")
	private String first_Name;
	
	@Column(name="LastName")
	private String last_Name;
	
	@Column(name="Email")
	private String email;
	
	
	@OneToOne(mappedBy="user",cascade = CascadeType.ALL)
	private UserDetail userDetail;

	
	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

//	public List<UserDetail> getUserDetail() {
//		return userDetail;
//	}
//
//	public void setUserDetail(List<UserDetail> userDetail) {
//		this.userDetail = userDetail;
//	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String first_Name, String last_Name, String email) {
		super();
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", first_Name=" + first_Name + ", last_Name=" + last_Name + ", email=" + email
				+ "]";
	}
	
	
}
