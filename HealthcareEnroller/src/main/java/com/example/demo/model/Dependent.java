package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "dependents")
public class Dependent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long dependentId;
	
	@NotNull
	private String dependentName;
	
	public Long getDependentId() {
		return dependentId;
	}
	public void setDependentId(Long dependentId) {
		this.dependentId = dependentId;
	}
	public String getDependentName() {
		return dependentName;
	}
	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	@Override
	public String toString() {
		return "Dependent [dependentId=" + dependentId + ", dependentName=" + dependentName + ", birthDate=" + birthDate
				+ ", fkEnroleeId=" + fkEnroleeId + "]";
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date birthDate;
	
	@OneToOne
	@JoinColumn(name="enroleeId")
    private Enrolee fkEnroleeId;
	


	public Enrolee getFkEnroleeId() {
		return fkEnroleeId;
	}
	public void setFkEnroleeId(Enrolee fkEnroleeId) {
		this.fkEnroleeId = fkEnroleeId;
	}
	
	
	

	
	
}