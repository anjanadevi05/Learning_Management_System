package com.ds.boot_demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds.boot_demo.entity.EmployeePrimaryDetails;

@Repository
public interface PrimaryInfoRepository extends JpaRepository<EmployeePrimaryDetails, Integer>{
	//write the queries.
	Optional<EmployeePrimaryDetails> findByemployeeId(String employeeId) ;
		// TODO Auto-generated method stub
		//not always return...so optional
		

}
