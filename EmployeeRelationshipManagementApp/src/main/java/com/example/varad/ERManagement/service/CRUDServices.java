package com.example.varad.ERManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.varad.ERManagement.entity.Employee;
import com.example.varad.ERManagement.repositories.EmployeeRepository;

@Service
public class CRUDServices {

	@Autowired
	EmployeeRepository empRepo;
	
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}
	
	public void createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		empRepo.save(emp);
	}

	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		empRepo.deleteById(id);
	}

	public Employee getEmployee(Integer id) {
		// TODO Auto-generated method stub
		return empRepo.findById(id).get();
	}

	public void update(Employee emp, Integer id) {
		// TODO Auto-generated method stub
		Employee toBeUpdated = getEmployee(id);
		toBeUpdated.setFirstName(emp.getFirstName());
		toBeUpdated.setLastName(emp.getLastName());
		toBeUpdated.setCity(emp.getCity());
		toBeUpdated.setDepartment(emp.getDepartment());
		toBeUpdated.setEmail(emp.getEmail());
		toBeUpdated.setMobileNo(emp.getMobileNo());
		toBeUpdated.setPosition(emp.getPosition());
		toBeUpdated.setSalary(emp.getSalary());
		empRepo.save(toBeUpdated);
	}

	public List<Employee> getPastEmployees() {
		// TODO Auto-generated method stub
		List<Employee> empL = getAllEmployees();		
		List<Employee> pastEmp = new ArrayList<>();
		
		for(int i=0; i<empL.size();i++) {
			Employee emp = empL.get(i);
			if(!emp.isCurrentEmp()) {
				pastEmp.add(emp);
			}
		}
		
		return pastEmp;
	}
	
	public List<Employee> getCurrentEmployees() {
		// TODO Auto-generated method stub
		List<Employee> empL = getAllEmployees();		
		List<Employee> currEmp = new ArrayList<>();
		
		for(int i=0; i<empL.size();i++) {
			Employee emp = empL.get(i);
			if(emp.isCurrentEmp()) {
				currEmp.add(emp);
			}
		}
		return currEmp;
	}
	
	public void removeEmployee(Integer id) {
		// TODO Auto-generated method stub
		Employee emp = getEmployee(id);
		emp.currentEmp(false);	
		empRepo.save(emp);
	}
	
	public void restoreEmployee(Integer id) {
		// TODO Auto-generated method stub
		Employee emp = getEmployee(id);
		emp.currentEmp(true);	
		empRepo.save(emp);
	}

	public List<Employee> itDeptEmployees() {
		// TODO Auto-generated method stub
		List<Employee> empL = getAllEmployees();		
		List<Employee> itDept = new ArrayList<>();
		
		for(int i=0; i<empL.size();i++) {
			Employee emp = empL.get(i);
			if(emp.getDepartment().trim().equalsIgnoreCase("it") && emp.isCurrentEmp()) {
				itDept.add(emp);
			}
		}
		return itDept;
	}
	
	public List<Employee> hrDeptEmployees() {
		// TODO Auto-generated method stub
		List<Employee> empL = getAllEmployees();		
		List<Employee> hrDept = new ArrayList<>();
		
		for(int i=0; i<empL.size();i++) {
			Employee emp = empL.get(i);
			if(emp.getDepartment().trim().equalsIgnoreCase("hr") && emp.isCurrentEmp()) {
				hrDept.add(emp);
			}
		}
		return hrDept;
	}
	
	public List<Employee> salesDeptEmployees() {
		// TODO Auto-generated method stub
		List<Employee> empL = getAllEmployees();		
		List<Employee> salesDept = new ArrayList<>();
		
		for(int i=0; i<empL.size();i++) {
			Employee emp = empL.get(i);
			if(emp.getDepartment().trim().equalsIgnoreCase("sales") && emp.isCurrentEmp()) {
				salesDept.add(emp);
			}
		}
		return salesDept;
	}
}
