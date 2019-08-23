package com.nt.command;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class LoginCommand {
	@NotBlank(message="username must not be blank")
	@Length(min=2,message="username must contain minimum 2 chars")
	private String username;
	@NotBlank(message="password must not be blank")
	private String password;

	//private String[] hobbies;  or
	private List<String> hobbies;
	private String country;
	
	private Date dob;
	
	public LoginCommand() {
        System.out.println("LoginCommand-no-param constructor");
	}
}
