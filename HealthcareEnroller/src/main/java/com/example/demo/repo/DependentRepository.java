package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.DependentDTO;
import com.example.demo.model.Dependent;
import com.example.demo.model.Enrolee;


@Repository
public interface DependentRepository extends JpaRepository<Dependent, Long> {
	@Modifying
    @Transactional
	@Query(value="delete  from dependents where enrolee_id =:enroleeId",nativeQuery =true)
	 void deleteByFkEnroleeId(Enrolee enroleeId);
	
	List<Dependent> findByFkEnroleeId(Enrolee enroleeId);
}
