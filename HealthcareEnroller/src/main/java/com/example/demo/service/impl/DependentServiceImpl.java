package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DependentDTO;
import com.example.demo.model.Dependent;
import com.example.demo.model.Enrolee;
import com.example.demo.repo.DependentRepository;
import com.example.demo.repo.EnroleeRepository;
import com.example.demo.service.DependentService;

@Service(value = "dependentService")
public class DependentServiceImpl implements DependentService {

	@Autowired
	DependentRepository dependentRepo;
	@Autowired
	EnroleeRepository enroleeRepo;
	
	
	@Override
	public List<Dependent> findByFkId(Enrolee enroleeId) {
		// TODO Auto-generated method stub
		return dependentRepo.findByFkEnroleeId(enroleeId);
	}
	@Override
	public Dependent save(Dependent dependent) {
		// TODO Auto-generated method stub
	
		
		return 	dependentRepo.save(dependent);
	}

	

}

