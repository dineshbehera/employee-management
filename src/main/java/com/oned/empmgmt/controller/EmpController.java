package com.oned.empmgmt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oned.empmgmt.model.Employee;
import com.oned.empmgmt.repository.EmployeeRepository;

@RestController
public class EmpController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String hello() {
        return "Hello ! Welcome to Employee management system !";
    }

    @GetMapping("/employees")
    public List<Employee> getEAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) {
        Optional<Employee> emp = employeeRepository.findById(employeeId);

        if (emp.isPresent()) {
            return new ResponseEntity<>(emp.get(), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable(value = "id") Long employeeId) {
        try {
            Optional<Employee> emp = employeeRepository.findById(employeeId);

            if (emp.isPresent()) {
                employeeRepository.delete(emp.get());
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/employee")
	public ResponseEntity<Employee> saveCustomer(@RequestBody Employee employee) {
		try {
			return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/employee")
	public ResponseEntity<Employee> updateCustomer(@RequestBody Employee employee) {
		try {
			return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
