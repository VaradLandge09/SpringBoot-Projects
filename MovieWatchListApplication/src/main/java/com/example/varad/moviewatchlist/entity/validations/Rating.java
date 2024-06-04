package com.example.varad.moviewatchlist.entity.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RatingAutonationLogic.class)
public @interface Rating {
	
	String message() default "Please Entre a Valid Range of rating 0.0 < Rating < 10.0";
	
	Class<?>[]groups() default {};
	Class<? extends Payload>[] payload() default {};

}
