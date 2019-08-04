package com.nt.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.CustomerCommand;

public class CustomerValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("CustomerValidator.supports()");
		return clazz.isAssignableFrom(CustomerCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("CustomerValidator.validate()");
		CustomerCommand cmd=null;
	     //type casting
		cmd=(CustomerCommand)target;
		//server side form validation logic
		if( cmd.getCustName()==null || cmd.getCustName().equals("") || cmd.getCustName().length()==0 )
			errors.rejectValue("custName","regCmd.custName.required");
		
		if(cmd.getCustAddrs()==null||cmd.getCustAddrs().equals("") || cmd.getCustAddrs().length()==0  )
			errors.rejectValue("custAddrs","regCmd.custAddrs.required");
		
	}

}
