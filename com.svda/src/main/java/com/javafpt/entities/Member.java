package com.javafpt.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idmember")
	private Integer idMember;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="male")
	private String male;
	
	@Column(name="name")
	private String name;
	
	@Column(name="birtday")
	private String birtday;
	

	public int getIdMember() {
		return idMember;
	}

	public void setIdMember(Integer idMember) {
		this.idMember = idMember;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMale() {
		return male;
	}

	public void setMale(String male) {
		this.male = male;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirtday() {
		return birtday;
	}

	public void setBirtday(String birtday) {
		this.birtday = birtday;
	}
	
	
	

	
}
