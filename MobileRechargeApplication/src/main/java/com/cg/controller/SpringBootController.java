package com.cg.controller;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bean.Employee;
import com.cg.employee.exception.EmployeeException;
import com.cg.employee.service.IEmployeeService;

@RestController
@Transactional

public class SpringBootController {
	@Autowired
	private IEmployeeService service;
	
	
	@RequestMapping(value="/message2",method=RequestMethod.POST)
	public Employee addEmployee( Employee employee) {
		try {
			service.addEmployee(employee);
			
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}		
		return employee;
	}

	@RequestMapping(value="/allemployees",method=RequestMethod.GET)
	public Collection<Employee> getAllEmployee() {
		
		Collection<Employee> employees=null;
		try {
			employees = service.getAllEmployees();
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		
		return employees;
		
	}
	@RequestMapping(value="/getemployeebyId",method=RequestMethod.GET)
	public Employee getEmployeeById( Integer id) {
		
		
		Employee employee=null;
		try {
			employee = service.getEmployeeById(id);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return employee;
		
		
	}
	
	@RequestMapping(value="/deleteEmployee",method=RequestMethod.GET)
	public Integer deleteEmployeeById(Integer id) {
		
		
		try {
			Integer employeeId=service.deleteEmployee(id);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return id;
		
	}
	
	
	@RequestMapping(value="/getEmployeeByDesignation",method=RequestMethod.GET)
	public List<Employee> getEmployeeByDesignation(String designation) {
		
		List<Employee> employees=null;
		try {
			employees=service.getEmployeeByDesignation(designation);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return employees;
		
		
	}
	
	@RequestMapping(value="/updateEmployee",method=RequestMethod.POST)
	public Employee updateEmployee(Integer id) {
		
		Employee employee=null;
		try {
			employee=service.updateEmployee(id);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return employee;
		
		
	}
}
