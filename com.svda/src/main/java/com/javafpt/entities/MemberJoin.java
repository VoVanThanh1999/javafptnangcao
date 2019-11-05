package com.javafpt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="memberjoin")
public class MemberJoin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	@Column(name="point1")
	private String point1;
	
	@Column(name="point2")
	private String point2;
	
	@Column(name="point3")
	private String point3;
	
	@Column(name="point4")
	private String point4;
	
	@Column(name="Registrationdate")
	private String registrationDate;
	
	@Column(name="comment")
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="idmember")
	Member member;
	
	@ManyToOne
	@JoinColumn(name="idaction")
	MemberAction memberAction;

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPoint1() {
		return point1;
	}

	public void setPoint1(String point1) {
		this.point1 = point1;
	}

	public String getPoint2() {
		return point2;
	}

	public void setPoint2(String point2) {
		this.point2 = point2;
	}

	public String getPoint3() {
		return point3;
	}

	public void setPoint3(String point3) {
		this.point3 = point3;
	}

	public String getPoint4() {
		return point4;
	}

	public void setPoint4(String point4) {
		this.point4 = point4;
	}

	

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public MemberAction getMemberAction() {
		return memberAction;
	}

	public void setMemberAction(MemberAction memberAction) {
		this.memberAction = memberAction;
	}
	
	
	
	
}
