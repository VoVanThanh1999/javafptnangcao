package com.javafpt.dto;

import org.springframework.stereotype.Component;

@Component
public class ActionDto {
	private Integer idAction;	
	private String reasonCancel;	
	private String describes;	
	private String description;	
	private String dateStart;
	private String datefinish;	
	private String numberMin;	
	private String numberMax;	
	private String nameAction;	
	private String timeDeadline;	
	private String status;
	private int  idMember;
	
	public Integer getIdAction() {
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
	public String getDateStart() {
		return dateStart;
	}
	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
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
	public int getIdMember() {
		return idMember;
	}
	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}
	
	
	
	
}
