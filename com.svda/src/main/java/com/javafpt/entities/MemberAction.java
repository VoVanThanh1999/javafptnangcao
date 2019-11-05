package com.javafpt.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="memberaction")
public class MemberAction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idaction")
	private Integer idAction;	
	
	@Column(name="reasoncancel")
	private String reasonCancel;	
	
	@Column(name="describes")
	private String describes;	
	
	@Column(name="description")
	private String description;	
	
	@Column(name="dateStart")
	private String dateStart;
	
	@Column(name="datefinish")
	private String datefinish;	
	
	@Column(name="numbermin")
	private String numberMin;	
	
	@Column(name="numbermax")
	private String numberMax;	
	
	@Column(name="nameaction")
	private String nameAction;	
	
	@Column(name="timedeadline")
	private String timeDeadline;	
	
	@Column(name="status")
	private String status;	
	
	@OneToOne
	@JoinColumn(name="idmember")
	Member member;

	public int getIdAction() {
		return idAction;
	}

	public void setIdAction(Integer idAction) {
		this.idAction = idAction;
	}

	public String getReasonCancel() {
		return reasonCancel;
	}

	public void setReasonCancel(String reasonCancel) {
		this.reasonCancel = reasonCancel;
	}

	public String getDescribes() {
		return describes;
	}

	public void setDescribes(String describes) {
		this.describes = describes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDatefinish() {
		return datefinish;
	}

	public void setDatefinish(String datefinish) {
		this.datefinish = datefinish;
	}

	public String getNumberMin() {
		return numberMin;
	}

	public void setNumberMin(String numberMin) {
		this.numberMin = numberMin;
	}

	public String getNumberMax() {
		return numberMax;
	}

	public void setNumberMax(String numberMax) {
		this.numberMax = numberMax;
	}

	public String getNameAction() {
		return nameAction;
	}

	public void setNameAction(String nameAction) {
		this.nameAction = nameAction;
	}

	public String getTimeDeadline() {
		return timeDeadline;
	}

	public void setTimeDeadline(String timeDeadline) {
		this.timeDeadline = timeDeadline;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}
	
	

}
