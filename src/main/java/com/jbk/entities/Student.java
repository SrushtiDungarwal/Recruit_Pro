package com.jbk.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Student {

	@Id
	@Column(name= "id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name= "name", nullable = false)
	private String name;
	
	@Column(name= "email_id", nullable = false, unique = true)
	private String email;
	
	@Column(name= "password", nullable = false)
	private String password;
	
	@Column(name= "contact_number", nullable = false, unique = true)
	private String contactNumber;
	
	@Column(name= "department", nullable = false)
	private String department;
	
	@Column(name= "graduation_year", nullable = false)
	private String graduationYear;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", contactNumber=" + contactNumber + ", department=" + department + ", graduationYear="
				+ graduationYear + "]";
	}
}
