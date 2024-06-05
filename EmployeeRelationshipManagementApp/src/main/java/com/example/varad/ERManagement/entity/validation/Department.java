package com.example.varad.ERManagement.entity.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DepartmentAutonationLogic.class)
public @interface Department {
	
	String message() default "Department dosen't exists please entre valid Departments";

	Class<?>[]groups() default {};
	Class<? extends Payload>[] payload() default {};
}
