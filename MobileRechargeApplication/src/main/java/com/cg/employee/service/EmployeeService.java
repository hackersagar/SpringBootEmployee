package com.cg.employee.service;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.auth.login.AccountException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bean.Employee;
import com.cg.employee.dao.IEmployeeDAO;
import com.cg.employee.exception.EmployeeException;
@Service
@PersistenceContext
public class EmployeeService implements IEmployeeService {
	@Autowired
	private EntityManager em;
	@Autowired
	private IEmployeeDAO dao;

	@Override
	public Collection<Employee> getAllEmployees() throws EmployeeException {
		// TODO Auto-generated method stub
		return dao.findAll();
	}



	@Override
	public Employee getEmployeeById(int id) throws EmployeeException {
		// TODO Auto-generated method stub
		return dao.getEmployeeById(id);
	}



	@Override
	public boolean validateEmployee(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		if(validateName(emp.getName())&& validateMobile(emp.getMobile())&& validateAge(emp.getAge())){
		return true;
	}
		return false;
	}
	
	
	private boolean validateName(String name) throws EmployeeException{
		if(name.isEmpty() ||name==null){
			throw new EmployeeException("Employee name cannot be empty");
		}
		else {
			if(!name.matches("[A-Z][A-za-z]{2,}")){
				throw new EmployeeException("Employee name should start with capital letter and should contain only alphabets and size should be greater than two");
			}
		}
		return true;
	}
	
	
	private boolean validateMobile(String mobile)throws EmployeeException{
		if(!mobile.matches("\\d{10}")){
			throw new EmployeeException("Mobile number should contain ten digits");
		}
		return true;
	}
	
	
	private boolean validateAge(Integer age) throws EmployeeException{
		if(age>=18 && age<=60){
		return true;
		}
		else{
			throw new EmployeeException("Age should be between 18 and 60");
		}
	}



	@Override
	public Integer addEmployee(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		Boolean boolean1=validateEmployee(emp);
		if(boolean1) {
		dao.save(emp);
		}else
		{
			throw new EmployeeException("Validation failed");
		}
		return emp.getId();
	}



	@Override
	public int deleteEmployee(int id) throws EmployeeException {
		// TODO Auto-generated method stub
		 dao.deleteById(id);
		 return id;
	}

	

	@Override
	public List<Employee> getEmployeeByDesignation(String Designation)
			throws EmployeeException {
		return dao.getEmployeeBydesignation(Designation);
	}


	/*
	@Override
	public Employee findSeniorMostEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		return employeeDao.findSeniorMostEmployee();
	}*/



	@Override
	public Employee updateEmployee(Integer id) throws EmployeeException {
		// TODO Auto-generated method stub
		Employee employee= dao.getEmployeeById(id);
		employee.setAge(25);
		employee.setDesignation("Associate");
		employee.setMobile("7894561230");
		employee.setSalary(123456);
		em.merge(employee);
		return employee;
	}




}
