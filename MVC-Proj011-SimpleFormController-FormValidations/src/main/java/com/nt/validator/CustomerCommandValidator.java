package com.nt.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.CustomerCommand;

public class CustomerCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(CustomerCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CustomerCommand cmd = null;

		cmd = (CustomerCommand) target;
		System.out.println(cmd.getHbox());

		if (cmd.getHbox().equalsIgnoreCase("no")) {
			if (cmd.getCname() == null || cmd.getCname().equals("") || cmd.getCname().length() == 0)
				errors.rejectValue("cname", "custCmd.cname.required");
			if (cmd.getCaddrs() == null || cmd.getCaddrs().equals("") || cmd.getCaddrs().length() == 0)
				errors.rejectValue("caddrs", "custCmd.caddrs.required");
			else if (cmd.getCaddrs().length() < 5 || cmd.getCaddrs().length() > 10)
				errors.rejectValue("caddrs", "custCmd.caddrs.range");
			
			if (cmd.getMobileNo() == null)
				errors.rejectValue("mobileNo", "custCmd.cmobile.required");
			else if (String.valueOf(cmd.getMobileNo()).length() != 10)
				errors.rejectValue("mobileNo", "custCmd.cmobile.length");

			if (cmd.getBillAmount() == null)
				errors.rejectValue("billAmount", "custCmd.cbillAmount.required");
		}
	}

}
