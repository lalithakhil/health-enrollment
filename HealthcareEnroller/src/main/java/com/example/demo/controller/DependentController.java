package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DependentDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Dependent;
import com.example.demo.model.Enrolee;
import com.example.demo.repo.DependentRepository;
import com.example.demo.repo.EnroleeRepository;
import com.example.demo.service.DependentService;
import com.example.demo.service.EnroleeService;


@RestController
@RequestMapping("/process")
public class DependentController {
	


	@Autowired
	private DependentService dependentService;
	
	@Autowired
	private DependentRepository dependentRepository;
	
	@PostMapping("/dependent")
	public Dependent createDependent( @RequestBody Dependent dependent) {
		System.out.println("inside");
		return dependentService.save(dependent);
	}
	
	@GetMapping("/dependent/{id}")
	public ResponseEntity<List<Dependent>> getEmployeeById(@PathVariable(value = "id") Long enroleeId)
	{		
		Enrolee enrolee = new Enrolee();
		enrolee.setEnroleeId(enroleeId);
		return ResponseEntity.ok().body(dependentService.findByFkId(enrolee));
	}
	
	  
	  @DeleteMapping("/dependent/{id}") public Map<String, Boolean>
	  deleteDependent(@PathVariable(value = "id") Long dependentId) throws ResourceNotFoundException{
		  Dependent dependent =
				  dependentRepository.findById(dependentId) .orElseThrow(() -> new
	  ResourceNotFoundException("Dependent not found for this id :: " + dependentId));
		  dependentRepository.delete(dependent); Map<String, Boolean> response = new
	  HashMap<>(); response.put("deleted", Boolean.TRUE); return response; }
	 
	
	@PutMapping("/dependent/{id}")
	public ResponseEntity<Dependent> updateDependent(@PathVariable(value = "id") Long dependentId,
			 @RequestBody Dependent dependentDetails) throws ResourceNotFoundException {
		Dependent dependent = dependentRepository.findById(dependentId)
				.orElseThrow(() -> new ResourceNotFoundException("E not found for this id :: " + dependentId));

		dependent.setBirthDate(dependentDetails.getBirthDate());
		dependent.setDependentName(dependentDetails.getDependentName());
		dependent.setDependentId(dependentDetails.getDependentId());
		dependent.setFkEnroleeId(dependentDetails.getFkEnroleeId());
		final Dependent updatedDependent = dependentRepository.save(dependent);
		return ResponseEntity.ok(updatedDependent);
	}
	
}
