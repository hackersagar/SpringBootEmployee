package com.cg.employee.service;

import java.util.Collection;
import java.util.List;

import com.cg.bean.Employee;
import com.cg.employee.exception.EmployeeException;

public interface IEmployeeService {
	/*Collection<Employee> getAllEmployees() throws EmployeeException;
	Employee getEmployeeById(int id) throws EmployeeException;
	boolean validateEmployee(Employee emp) throws EmployeeException;*/
	/*int deleteEmployee(int id) throws EmployeeException;
	List<Employee> getEmployeeByDesignation(String Designation) throws EmployeeException;
	Employee findSeniorMostEmployee() throws EmployeeException;
	int updateEmployee(Employee emp) throws EmployeeException;
*/
	Integer addEmployee(Employee emp) throws EmployeeException;
	Collection<Employee> getAllEmployees() throws EmployeeException;
	Employee getEmployeeById(int id) throws EmployeeException;
	int deleteEmployee(int id) throws EmployeeException;
	List<Employee> getEmployeeByDesignation(String Designation) throws EmployeeException;
	Employee updateEmployee(Integer id) throws EmployeeException;
	boolean validateEmployee(Employee emp) throws EmployeeException;

}
