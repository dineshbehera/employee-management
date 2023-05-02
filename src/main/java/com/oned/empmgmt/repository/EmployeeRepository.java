package com.oned.empmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oned.empmgmt.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
