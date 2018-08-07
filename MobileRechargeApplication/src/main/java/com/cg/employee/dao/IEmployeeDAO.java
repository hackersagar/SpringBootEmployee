package com.cg.employee.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.bean.Employee;

public interface IEmployeeDAO extends JpaRepository<Employee, Integer> {
	/*Collection<Employee> getAllEmployees() throws EmployeeException;
	Employee getEmployeeById(int id) throws EmployeeException;
	Integer addEmployee(Employee emp) throws EmployeeException;
	int deleteEmployee(int id) throws EmployeeException;
	List<Employee> getEmployeeByDesignation(String Designation) throws EmployeeException;
	Employee findSeniorMostEmployee() throws EmployeeException;
	int updateEmployee(Employee emp) throws EmployeeException;*/
	
	@Query("select e from Employee e where e.id=:id")
	Employee getEmployeeById(@Param("id") int id);
	
	@Query("select e from Employee e where e.designation=:designation")
	List<Employee> getEmployeeBydesignation(@Param("designation") String designation);
	
	
} 
