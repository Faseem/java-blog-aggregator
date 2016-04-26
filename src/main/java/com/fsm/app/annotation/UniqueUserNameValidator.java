package com.fsm.app.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.fsm.app.repository.UserRepository;

public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String>{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void initialize(UniqueUserName constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String userName, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(userRepository == null){
			return true;
		}
		return userRepository.findByName(userName)==null;
	}

}
