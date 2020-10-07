package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Enrolee;

@Repository
public interface EnroleeRepository extends JpaRepository<Enrolee, Long>{



}
