package com.example.varad.ERManagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.varad.ERManagement.entity.Employee;
import com.example.varad.ERManagement.service.CRUDServices;

import jakarta.validation.Valid;

@RestController
public class Controller {

	@Autowired
	CRUDServices services;

	@GetMapping()
	public ModelAndView indexPage() {
		String viewName = "index";
		
		HashMap<String, Object> model = new HashMap<>();
		model.put("ITEmps", services.itDeptEmployees().size());
		model.put("HREmps", services.hrDeptEmployees().size());
		model.put("SalesEmps", services.salesDeptEmployees().size());
		model.put("TotalEmp", services.getCurrentEmployees().size());
		
		return new ModelAndView(viewName, model);
	}
	
	@GetMapping("/index")
	public ModelAndView indexPage2() {
		String viewName = "index";
		
		HashMap<String, Object> model = new HashMap<>();
		model.put("ITEmps", services.itDeptEmployees().size());
		model.put("HREmps", services.hrDeptEmployees().size());
		model.put("SalesEmps", services.salesDeptEmployees().size());
		model.put("TotalEmp", services.getCurrentEmployees().size());
		
		return new ModelAndView(viewName, model);
	}
	
	@GetMapping("/register")
	public ModelAndView showEmp(@RequestParam(required = false) Integer id) {
		String viewName = "register";
		Map<String, Employee> model = new HashMap<>();
		if(id == null) {
			model.put("emp", new Employee());			
		} else {
			model.put("emp", services.getEmployee(id));						
		}
		return new ModelAndView(viewName, model);
	}

	@PostMapping("/register")
	public ModelAndView createEmp(@Valid @ModelAttribute(name = "emp") Employee emp, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return new ModelAndView("register");
		}
		Integer id = emp.getId();
		if(id == null) {
			services.createEmployee(emp);			
		} else {
			services.update(emp, id);						
		}

		RedirectView rd = new RedirectView();
		rd.setUrl("/empList");

		return new ModelAndView(rd);
	}

	@GetMapping("/empList")
	public ModelAndView showEmpList(@RequestParam(required = false) Integer id) {
		String viewName = "empList";
		
		if(id != null) {
			services.restoreEmployee(id);
		}
		Map<String, Object> model = new HashMap<>();
		model.put("Employees", services.getCurrentEmployees());
		model.put("EmpNumber", services.getCurrentEmployees().size());

		return new ModelAndView(viewName, model);
	}

	@GetMapping("/profile")
	public ModelAndView getProfile(@RequestParam("id") Integer id) {
		String viewName = "profile";

		Map<String, Object> model = new HashMap<>();
		model.put("Emp", services.getEmployee(id));

		return new ModelAndView(viewName, model);
	}

	@GetMapping("/past")
	public ModelAndView getPast(@RequestParam(required = false) Integer id) {
		String viewName = "past";
		
		if(id != null) {
			services.removeEmployee(id);
		}
		List<Employee> pastEmp = services.getPastEmployees();
		Map<String, Object> model = new HashMap<>();
		model.put("EmpL", pastEmp);
		model.put("pastNo", pastEmp.size());
		
		return new ModelAndView(viewName, model);
	}
	
	@GetMapping("/it")
	public ModelAndView itDept() {
		String viewName = "it";
		
		List<Employee> itDept = services.itDeptEmployees();
		Map<String, Object> model = new HashMap<>();
		model.put("itEmp", itDept);
		model.put("itEmpNumber", itDept.size());
		
		return new ModelAndView(viewName, model);
	}
	
	@GetMapping("/hr")
	public ModelAndView hrDept() {
		String viewName = "hr";
		
		List<Employee> hrDept = services.hrDeptEmployees();
		Map<String, Object> model = new HashMap<>();
		model.put("hrEmp", hrDept);
		model.put("hrEmpNumber", hrDept.size());
		
		return new ModelAndView(viewName, model);
	}
	
	@GetMapping("/sales")
	public ModelAndView salesDept() {
		String viewName = "sales";
		
		List<Employee> salesDept = services.salesDeptEmployees();
		Map<String, Object> model = new HashMap<>();
		model.put("salesEmp", salesDept);
		model.put("salesEmpNumber", salesDept.size());
		
		return new ModelAndView(viewName, model);
	}
}
