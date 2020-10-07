package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.DependentDTO;
import com.example.demo.model.Dependent;
import com.example.demo.model.Enrolee;

@Service(value = "dependentService")
public interface DependentService {

	List<Dependent> findByFkId(Enrolee enroleeId);

	Dependent save(Dependent dependent);
}
