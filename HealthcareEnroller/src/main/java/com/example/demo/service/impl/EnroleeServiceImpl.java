package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DependentDTO;
import com.example.demo.dto.EnroleeDTO;
import com.example.demo.model.Dependent;
import com.example.demo.model.Enrolee;
import com.example.demo.repo.EnroleeRepository;
import com.example.demo.service.DependentService;
import com.example.demo.service.EnroleeService;

@Service(value = "enroleeService")
public class EnroleeServiceImpl implements EnroleeService {

	
	@Autowired
	EnroleeRepository enroleeRepo;
	@Autowired
	DependentService dependentService;
	@Override
	public Enrolee findById(Long id) {
		// TODO Auto-generated method stub
		return enroleeRepo.findById(id).get();
	}
	@Override
	public EnroleeDTO findByEnroleeId(Long enroleeId) {
		// TODO Auto-generated method stub
		 EnroleeDTO enroleeDTO = new EnroleeDTO();
		 List<Dependent> dependent = dependentService.findByFkId(enroleeRepo.findById(enroleeId).get());
		 List<DependentDTO> dependentDTOList = new ArrayList<>();
		 for(int i=0; i<dependent.size();i++) {
			 DependentDTO dependentDTO = new DependentDTO();
			 dependentDTO.setBirthdate(dependent.get(i).getBirthDate());
			 dependentDTO.setDname(dependent.get(i).getDependentName());
			 dependentDTO.setDependentId(dependent.get(i).getDependentId());
			 dependentDTOList.add(dependentDTO);
		 }
		 enroleeDTO.setEnrolee( enroleeRepo.findById(enroleeId).get());
		 enroleeDTO.setDependentList(dependentDTOList);
		return enroleeDTO;
	}

}
