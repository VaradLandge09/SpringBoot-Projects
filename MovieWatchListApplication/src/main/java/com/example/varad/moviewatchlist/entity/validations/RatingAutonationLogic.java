package com.example.varad.moviewatchlist.entity.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RatingAutonationLogic implements ConstraintValidator<Rating, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		float rating = Float.parseFloat(value);
		return rating>0 && rating<10;
	}
	
}
