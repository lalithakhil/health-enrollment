package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.EnroleeDTO;
import com.example.demo.model.Enrolee;

@Service(value = "enroleeService")
public interface EnroleeService {
	
	Enrolee findById(Long id);

	EnroleeDTO findByEnroleeId(Long enroleeId);

}
