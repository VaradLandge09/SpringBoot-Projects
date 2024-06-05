package com.example.varad.ERManagement.entity.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DepartmentAutonationLogic implements ConstraintValidator<Department, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return (value.trim().length()==2 || value.trim().length()==5) && (value.equalsIgnoreCase("it") || value.equalsIgnoreCase("hr") || value.equalsIgnoreCase("sales"));
	}

}
