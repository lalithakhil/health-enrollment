package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EnroleeDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Enrolee;
import com.example.demo.repo.DependentRepository;
import com.example.demo.repo.EnroleeRepository;
import com.example.demo.service.DependentService;
import com.example.demo.service.EnroleeService;

@RestController
@RequestMapping("/process")
public class EnroleeController {
	@Autowired
	private EnroleeRepository enroleeRepository;

	@Autowired
	private EnroleeService enroleeService;

	@Autowired
	private DependentRepository dependentRepository;
	
	@GetMapping("/enrolee")
	public List<Enrolee> getAllEnrolees() {
		return enroleeRepository.findAll();
	}

	@GetMapping("/enrolee/{id}")
	public ResponseEntity<EnroleeDTO> getEmployeeById(@PathVariable(value = "id") Long enroleeId)
	{		
		return ResponseEntity.ok().body(enroleeService.findByEnroleeId(enroleeId));
	}

	@PostMapping("/enrolee")
	public Enrolee createEnrolee( @RequestBody Enrolee enrolee) throws Exception {
		if(enroleeRepository.existsById(enrolee.getEnroleeId()))throw new Exception("Enroller Already Exist");
		return enroleeRepository.save(enrolee);
	}

	
	  @PutMapping("/enrolee/{id}") 
	  public ResponseEntity<Enrolee>
	  updateEnrolee(@PathVariable(value = "id") Long enroleeId,  @RequestBody Enrolee enroleeDetails) {
		  Enrolee enrolee = new Enrolee();
	  
	  enrolee.setBirthDate(enroleeDetails.getBirthDate());
	  enrolee.setActivationStatus(enroleeDetails.getActivationStatus());
	  enrolee.setEnroleeId(enroleeId);
	  enrolee.setName(enroleeDetails.getName());
	  final Enrolee updatedEmployee =  enroleeRepository.save(enrolee); 
	  return ResponseEntity.ok(updatedEmployee); 
	  }
	  
	  @DeleteMapping("/enrolee/{id}") 
	  public Map<String, Boolean>
	  deleteEnrolee(@PathVariable(value = "id") Long enroleeId) throws ResourceNotFoundException{
		  Enrolee enrolee = enroleeRepository.findById(enroleeId) .orElseThrow(() -> new  ResourceNotFoundException("Employee not found for this id :: " + enroleeId));
	  dependentRepository.deleteByFkEnroleeId( enroleeRepository.findById(enroleeId).get());
		  enroleeRepository.delete(enrolee); 
	  Map<String, Boolean> response = new HashMap<>(); 
	  response.put("deleted", Boolean.TRUE); 
	  return response; }
	 
	
	
}
