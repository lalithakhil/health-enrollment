package com.example.demo.dto;

import java.sql.Date;

public class DependentDTO {

	private Long dependentId;
	@Override
	public String toString() {
		return "DependentDTO [dependentId=" + dependentId + ", dname=" + dname + ", status=" + status + ", birthdate="
				+ birthdate +  "]";
	}
	private String dname;
	public Long getDependentId() {
		return dependentId;
	}
	public void setDependentId(Long dependentId) {
		this.dependentId = dependentId;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	private Boolean status;
	private Date birthdate;
}
