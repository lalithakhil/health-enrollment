package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Dependent;
import com.example.demo.model.Enrolee;

public class EnroleeDTO {

	private Enrolee enrolee;
	private List<DependentDTO> dependentList;
	@Override
	public String toString() {
		return "EnroleeDTO [enrolee=" + enrolee + ", dependentList=" + dependentList + "]";
	}
	public Enrolee getEnrolee() {
		return enrolee;
	}
	public void setEnrolee(Enrolee enrolee) {
		this.enrolee = enrolee;
	}
	public List<DependentDTO> getDependentList() {
		return dependentList;
	}
	public void setDependentList(List<DependentDTO> dependentDTOList) {
		this.dependentList = dependentDTOList;
	}
}
