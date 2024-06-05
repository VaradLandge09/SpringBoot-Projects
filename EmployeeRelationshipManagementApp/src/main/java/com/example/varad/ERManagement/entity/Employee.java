package com.example.varad.ERManagement.entity;

import com.example.varad.ERManagement.entity.validation.Department;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message = "FirstName Cannot be blank")
	private String firstName;
	
	@NotBlank(message = "LastName Cannot be blank")
	private String lastName;
	
	@Size(min = 10, max = 10, message = "Please entre a valid mobile number")
	private String mobileNo;
	
	@Email
	private String email;
	
	private String city;
	
	private int salary;
	
	private String position;
	
	@Department
	private String department;
	
	private boolean currentEmp = true;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return lastName+firstName;
	}
	public boolean isCurrentEmp() {
		return currentEmp;
	}
	public void currentEmp(boolean currEmp) {
		this.currentEmp = currEmp;
	}
	
}
