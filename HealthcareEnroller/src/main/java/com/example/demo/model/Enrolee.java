package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "enrolee")
public class Enrolee {

	@Id
	private Long enroleeId;
	
	public Long getEnroleeId() {
		return enroleeId;
	}

	private String phoneNumber;
	@NotNull
	private String name;
	@NotNull
	private Boolean activationStatus;
	

	

	

	@Override
	public String toString() {
		return "Enrolee [enroleeId=" + enroleeId + ", phoneNumber=" + phoneNumber + ", name=" + name
				+ ", activationStatus=" + activationStatus + ", birthDate=" + birthDate + "]";
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Boolean getActivationStatus() {
		return activationStatus;
	}
	public void setActivationStatus(Boolean activationStatus) {
		this.activationStatus = activationStatus;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public void setEnroleeId(Long enroleeId) {
		this.enroleeId = enroleeId;
	}
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date birthDate;
	
	
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

	public void setEnroleeId(long enroleeId) {
		this.enroleeId = enroleeId;
	}
	public Object getstatus() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setstatus(Object getstatus) {
		// TODO Auto-generated method stub
		
	}

	
	
}

