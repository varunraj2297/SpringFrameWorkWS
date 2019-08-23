package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.LoginCommand;

@Component("validator")
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("LoginValidator.supports()");
		return clazz.isAssignableFrom(LoginCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("LoginValidator.validate()");
		LoginCommand loginCmd=null;
		loginCmd=(LoginCommand)target;
		
		if(loginCmd.getUsername()==null||loginCmd.getUsername().equals("")||loginCmd.getUsername().length()==0)
			errors.rejectValue("username", "username.required");
		
		if(loginCmd.getPassword()==null||loginCmd.getPassword().equals("")||loginCmd.getPassword().length()==0)
			errors.rejectValue("password", "password.required");
		
	}
   
}
